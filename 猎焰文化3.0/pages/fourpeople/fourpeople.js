// pages/fourpeople/fourpeople.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      '../image/forback.png',
    ],


    message: "您将支付一人学车的费用，这些费用将不予退还，如果您后期将要取得，请咨询客服询问详细情况!",
    flag: true
  },
  show: function () {
    this.setData({ flag: false })
  },
  hide: function () {
    this.setData({ flag: true })
  },
  Toentryform: function () {
    var that =this;
    that.setData({
      car: "四人学车"
    })
    app.globalData.car = that.data.car
    wx.navigateTo({
      url: '../entryform/entryform',
    })
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
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