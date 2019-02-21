// pages/personal/chteacher/chteacher.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    reason:'',
    openid:null,
    userInfo:""
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
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this
  
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
  rea_input:function(e){
    this.setData(
      {
        reason:e.detail.value
      }
    )

  },
  hand_in:function(){
    var that=this;
    wx.request({
      url: 'https://www.lieyanwenhua.com/changeteacherinsert',
      data:{
        "openid":that.data.openid,
        "tid":"1",
        "reason":that.data.reason
      },
      method:'POST',
      header:{
        'content-type':'application/x-www-form-urlencoded'
      },
      success:function(res){
        if(res.data==true){
          // wx.showToast({
          //   title: '提交成功',
          // })
          wx.showToast({
            title: '我们会尽快处理',
            icon: 'success',
            duration:2000
          })
          setTimeout(function() {
            var pages = getCurrentPages()
            var tempPage = pages[pages.length - 2]
            wx.navigateBack({
            })
          },1500)
        }

      }
    })

  }


})