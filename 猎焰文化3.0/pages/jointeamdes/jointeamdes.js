var app = getApp()
Page({
  data: {
    userInfo: "",
    pic_url: [
      "../image/carpack2.jpg",
      "../image/carpack1.jpg",
    ],
    detailgood: [],
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 100,
    hideif: true,
    name: '',
    tel: '',
    address: '',
    qq: '',
    id: '',
    openid: "",
    off: "",
    teamid:""
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var teamid = options.teamid;
    var that = this;
    that.setData({
      teamid: options.teamid
    })
    wx.request({
      url: 'https://www.lieyanwenhua.com/packageid',
      data: {
        packid: 3
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res.data);
        that.setData({
          detailgood: res.data
        })
        console.log(that.data.detailgood);
      }
    })
  },

  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },

  purchase: function () {
    var that = this
    console.log("这里开始进入")
    wx.navigateTo({
      url: '../jointeam/jointeam?teamid=' + that.data.teamid,
    })
  
  },
  cancelthis: function () {
    var that = this
    that.setData({
      hideif: true
    })
  },
  name: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  tel: function (e) {
    this.setData({
      tel: e.detail.value
    })
  },
  address: function (e) {
    this.setData({
      address: e.detail.value
    })
  },
  qq: function (e) {
    this.setData({
      qq: e.detail.value
    })
  },
  nexttap: function () {
   
  }
})
