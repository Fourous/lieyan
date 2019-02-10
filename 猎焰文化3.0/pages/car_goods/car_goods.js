var app = getApp()
Page({
  data: {
    pic_url:[
      "../image/teacher1.png",
      "../image/teacher1.png",
      "../image/teacher1.png",
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 100,
    hideif:true,
    name:'',
    tel:'',
    address:'',
    qq:''
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var id = options.id;
    var that = this;
    console.log("taocan"+id);
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
      hideif:false
      })
  },
  cancelthis:function(){
    var that=this
    that.setData({
      hideif:true
    })
  },
  nexttap:function(){
    var that = this
    console.log(this.data.name + this.data.tel + this.data.address + this.data.qq)
    //首先判断必填项是否为空，为空提示，不为空则继续下一步
    if (this.data.name == "" | this.data.tel == "" | this.data.address == "" | this.data.qq == "") {
      wx.showToast({
        title: '必填项缺失',
      })
    }
    else {
      wx.navigateTo({
        url: '../formpay/formpay?name=' + that.data.name + '&tel=' + that.data.tel + '&address=' + that.data.address + '&qq=' + that.data.qq,
      })

    }

  }
  }

})
