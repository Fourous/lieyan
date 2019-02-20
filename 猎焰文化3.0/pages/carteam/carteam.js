var app = getApp()
Page({
  data: {
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
    teamname:'',
    name: '',
    tel: '',
    address: '',
    qq: '',
    id: ''
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var id = options.id;
    var that = this;
    console.log("taocan" + id);
    that.setData({
      id: options.id
    })
    wx.request({
      url: 'https://www.lieyanwenhua.com/packageid',
      data: {
        packid: id
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
    console.log(that.data.hideif);
    that.setData({
      hideif: false
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
  teamname:function(e){
    this.setData({
      teamname: e.detail.value
    })
  },
  nexttap: function () {
    var that = this
    console.log(this.data.name + this.data.tel + this.data.address + this.data.qq)
    //首先判断必填项是否为空，为空提示，不为空则继续下一步
    if (this.data.name == "" | this.data.tel == "" | this.data.address == "" | this.data.qq == "") {
      wx.showToast({
        title: '必填项缺失',
      })
      console.log(this.data.teamname)
    }
    else {
      wx.navigateTo({
        url: '../teampay/teampay?name=' + that.data.name + '&tel=' + that.data.tel + '&address=' + that.data.address + '&qq=' + that.data.qq + '&car=' + that.data.id + '&packname=' + that.data.detailgood.packname,
      })

    }

  }


})
