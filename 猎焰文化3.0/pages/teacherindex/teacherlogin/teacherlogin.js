// pages/teacherindex/teacherlogin/teacherlogin.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bgpic: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
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
  searchBox:function(e){
    console.log(e)
  const that=this;
  var username=e.detail.value.username;//分别是工号和密码
  var passwd=e.detail.value.pwd;
    wx.request({
      url: 'https://www.lieyanwenhua.com/islogin',
      method: 'POST',
      data: {
        'username': username,
        'passwd':passwd
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res);
       if(res.data==-1){
         wx.showToast({
           title: '用户不存在',
           icon: 'loading'
         })
       } else if (res.data == 0) {
         wx.showToast({
           title: '账号密码错误',
           icon: 'loading'
         })
       }
       else if(res.data>0){
        wx.navigateTo({
          url: '../teachertable/teachertable?tid='+res.data,
        })
      }
      }
    })
  }
})