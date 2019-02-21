// pages/personal/personal/personal.js
var app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userdata:null,
    Customer_call:'15207167639',
    openid:'',
    teacher:"",
    nickname:"",
    userInfo:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        console.log("cheng");
        that.setData({
          userInfo: res.data
        })
        console.log("jia");
      },
    });
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid:res.data
        })
        console.log(that.data.openid)
      },
    });

    
   
   
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
      var that=this
   

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
    console.log(that.data.openid)
    //这里每次显示的时候，通过openID请求所有数据，包括头像等信息
    wx.request({
      url: 'https://www.lieyanwenhua.com/userqueryByid',
      method: 'POST',
      data: {
        'openid': that.data.openid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res);
        // that.setData({
        //   nickname:res.data.userbyid.nickname
        // })
        console.log("打印出来" + res.data.userbyid.nickName);
        that.setData({
          nickname: res.data.userbyid.nickName
        })
        if (res.data.userbyid.bindteacher == 0) {
          that.setData({
            teacher: "未绑定"
          })
        } else {
          wx.request({
            url: 'https://www.lieyanwenhua.com/getcoachname',
            method: 'POST',
            data: {
              'tid': res.data.userbyid.bindteacher
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            success: function (res) {
              console.log(res);
              that.setData({
                teacher: res.data
              })
            },
            fail: function (res) {
              console.log(res);
            }
          })
        }
        that.setData({
          userdata: res.data.userbyid
        })
       
        console.log(that.data.nickname);
      },
      fail: function (res) {
        console.log(res);
      }
    })

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
  TOchteacher:function(){
    wx.navigateTo({
      url: '../chteacher/chteacher',
    })
  },
  Tofeedback:function(){
    wx.navigateTo({
      url: '../feedback/feedback',
    })
  },
  Toaffair:function(){
    wx.navigateTo({
      url: '../../mycir/mycir',
    })
    // wx.showToast({
    //   title: '敬请期待！',
    //   icon: 'loading'
    // })
  },
  Toround:function(){
   /* wx.navigateTo({
      url: '../myround/myround',
    })*/
    wx.showToast({
      title: '敬请期待！',
      icon:'loading'
    })
  },
  Tostore:function(){
    wx.showToast({
      title: '敬请期待！',
      icon: 'loading'
    })
  },
  Tofun:function(){
    wx.navigateTo({
      url: '../../myteam/myteam',
    })
  },
  Tocustom:function(){
    wx.makePhoneCall({
      phoneNumber: this.data.Customer_call,
      success:function(){
        wx.showToast({
          title: '成功拨打该电话',
        })
      }
    })
  },
  Toback:function(){
    wx.navigateTo({
      url: '../../directlogin/directlogin',
    })
  },
  tobindteacher:function(){
    wx.navigateTo({
      url: '../../bindteacher/bindteacher',
    })
  },
  Toteacherorder:function(){
    //这里是跳转到教练的课表页面
    wx.navigateTo({
      url: '../../teacherindex/teacherlogin/teacherlogin',
    })
  },
  changenickname:function(){
    var that=this;
    console.log(that.data.nickname);
    wx.navigateTo({
      url: '../changeone/changeone?nickname=' + that.data.nickname,
    })
  }

})