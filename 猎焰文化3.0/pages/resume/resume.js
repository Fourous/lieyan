// pages/resume/resume.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    resumepng:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showToast({
      title: '加载中.....',
      icon: 'loading',
      duration: 2000
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this
    let url = "https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/advertising/res1.png"
    wx.downloadFile({
      url: url,
      success: (res) => {
        let temp = res.tempFilePath
        console.log(res)
        that.setData({
          resumepng: temp
        })
        console.log(temp)
        console.log(that.data.resumepng)
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

  }
})