// pages/orderteacher/orderteacher.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bgpic: null,
    tid: null,
    openid: '',
    week: [
      "周一", "周二", "周三", "周四", "周五", "周六", "周日",
    ],
    // class: [
    // {
    //   class: [{
    //     num: 1,
    //     yysta: 0,
    //     tsta: 1
    //   }, {
    //     num: 2,
    //     yysta: 0,
    //     tsta: 0
    //   }, {
    //     num: 3,
    //     yysta: 0,
    //     tsta: 0
    //   }
    // , {
    //     num: 4,
    //     yysta: 0,
    //     tsta: 0
    //   }]
    // }, {
    //   class: [{
    //     num: 5,
    //     yysta: 1,
    //     tsta: 0
    //   }, {
    //     num: 6,
    //     yysta: 0,
    //     tsta: 0
    //   }, {
    //     num: 7,
    //     yysta: 0,
    //     tsta: 0
    //   }, {
    //     num: 8,
    //     yysta: 0,
    //     tsta: 0
    //   }]
    //   }, {
    //     class: [{
    //       num: 1,
    //       yysta: 0,
    //       tsta: 1
    //     }, {
    //       num: 2,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 3,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 4,
    //       yysta: 0,
    //       tsta: 0
    //     }]
    //   }, {
    //     class: [{
    //       num: 1,
    //       yysta: 0,
    //       tsta: 1
    //     }, {
    //       num: 2,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 3,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 4,
    //       yysta: 0,
    //       tsta: 0
    //     }]
    //   }, {
    //     class: [{
    //       num: 1,
    //       yysta: 0,
    //       tsta: 1
    //     }, {
    //       num: 2,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 3,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 4,
    //       yysta: 0,
    //       tsta: 0
    //     }]
    //   }, {
    //     class: [{
    //       num: 1,
    //       yysta: 0,
    //       tsta: 1
    //     }, {
    //       num: 2,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 3,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 4,
    //       yysta: 0,
    //       tsta: 0
    //     }]
    //   }, {
    //     class: [{
    //       num: 1,
    //       yysta: 0,
    //       tsta: 1
    //     }, {
    //       num: 2,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 3,
    //       yysta: 0,
    //       tsta: 0
    //     }, {
    //       num: 4,
    //       yysta: 0,
    //       tsta: 0
    //     }]
    //   }]
    classsigns: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    console.log(options.tid);
    var that = this;
    that.setData({
      tid: options.tid
    })
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid: res.data
        })
        console.log(that.data.openid)
      }
    }),
      console.log(that.data.tid);
    let url = "https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/welcome/welcome.png"
    wx.downloadFile({
      url: url,
      success: (res) => {
        let temp = res.tempFilePath
        that.setData({
          bgpic: temp
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // 这里生成时间，将这个时间传到服务器，来判别当前时间
    var that = this;
    // var timestamp = Date.parse(new Date());
    // console.log(timestamp);
    // console.log(that.data.tid);
    wx.request({
      url: 'https://www.lieyanwenhua.com/teachermap',
      method: 'POST',
      data: {
        "tid": that.data.tid,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log(res.data);
        that.setData({
          classsigns: res.data
        })
        console.log(that.data.classsigns[0].classsigns[1]);

        console.log(that.data.classsigns);
        if (res.data = null || res.data == 0) {
          wx.showToast({
            title: '系统出错',
            icon: "loading",
            duration: 2200,
          })
          setInterval(function () {
            wx.navigateBack({

            })
          }, 2000)

          //系统出错，然后自动退出
        }

      },
      fail: function () {

      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  yuyue: function (e) {
    console.log(e)
    var that = this;
    var weekI = e.currentTarget.dataset.weeki;
    var classI = e.currentTarget.dataset.classi;
    var sta = that.data.classsigns[weekI].classsigns[classI].userstate ? 0 : 1;
    that.data.classsigns[weekI].classsigns[classI].userstate = sta;
    if (sta == 0) {
      that.data.classsigns[weekI].classsigns[classI].num++;
      console.log(that.data.classsigns[weekI].classsigns[classI].num);
      that.setData({
        classsigns: that.data.classsigns
      })
      wx.showToast({
        title: '取消预约',
      })
    } else {
      that.data.classsigns[weekI].classsigns[classI].num--;
      console.log(that.data.classsigns[weekI].classsigns[classI].num);
      that.setData({
        classsigns: that.data.classsigns
      })
      wx.showToast({
        title: '预约成功',
      })
    }

  }
})