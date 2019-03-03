// pages/myteam/myteam.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid:'',
    list:0,
    namelist:"",
    userInfo:"",
    teamid:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid: res.data
        })
        console.log(that.data.openid)
      },
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this
    wx.request({
      url: 'https://www.lieyanwenhua.com/listteam',
      method: 'POST',
      data: {
        "openid":this.data.openid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
       console.log(res.data);
       console.log(res.data==null)
       console.log(res.data=="")
       if(res.data==null||res.data==""){
         that.setData({
           list: 0,
         })
       }
       else {
         that.setData({
           list: 1,
           namelist: res.data
         })
         console.log(that.data.namelist)
       }
      },
      fail: function (res) {
        console.log(res);

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
  findteam:function(){
  wx.redirectTo({
    url: '../carteam/carteam?id='+3,
  })
  },
  onShareAppMessage: function (ops) {
    var that=this
    if (ops.from === 'button') {
      // 来自页面内转发按钮
      console.log(ops.target)
    }
    return {
      title: '邀请加入战队',
      path: 'pages/jointeamdes/jointeamdes?teamid='+that.data.namelist[0].teamid,
      imageUrl:"../image/invitefr.jpg",
      success: function (res) {
        // 转发成功
        console.log("转发成功:" + JSON.stringify(res));
        wx.showToast({
          title: '转发成功',
          duration:2000,
        })
        wx.navigateBack({
          delta:1
        })
      },
      fail: function (res) {
        // 转发失败
        console.log("转发失败:" + JSON.stringify(res));
        wx.showToast({
          title: '服务器宕机',
        })
      }
    }

  },
  choose:function(){
    var that=this
    wx.request({
      url: 'https://www.lieyanwenhua.com/canpush',
      data: {
        openid: that.data.openid
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res.data);
        if(res.data){
          wx.request({
            url: 'https://www.lieyanwenhua.com/canpush',
            data: {
              openid: that.data.openid
            },
            method: 'POST',
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            success: (res) => {
              console.log(res.data);
              if(res.data){
                wx.showToast({
                  title: '开始练车吧',
                })
              }
            }
          })
        }else{
          wx.showModal({
            title: '提示',
            content: '报名需要满足4人',
          })
        }
      }
    })
  }

})