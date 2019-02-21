// pages/mycir/mycir.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:[],
    openid:"",
    cir:[],
    deleteid:-1,
    userInfo:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        console.log("cheng");
        that.setData({
          userInfo: res.data
        })
      },
    });
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid: res.data
        })
        wx.request({
          url: 'https://www.lieyanwenhua.com/ciropenid',
          header: { "Content-Type": "application/x-www-form-urlencoded" },
          method: 'POST',
          data: {
            openid: that.data.openid
          },
          success: function (res) {
            console.log(res)
            var cir= res.data.ciropenid;
            that.setData({
              cir: cir
            })
          }
        })
      }
    });
    //console.log(that.data.openid)
    // wx.request({
    //   url:'https://www.lieyanwenhua.com/ciropenid',
    //   header: { "Content-Type": "application/x-www-form-urlencoded" },
    //   method: 'POST',
    //   data: {
    //     openid: that.data.openid
    //   },
    //   success:function(res){
    //     console.log(res)
    //   }
    // })
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

  }
})