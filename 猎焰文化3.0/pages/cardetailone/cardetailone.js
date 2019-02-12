// pages/cardetailone/cardetailone.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    carid:null,
    cardetail:null,
    scale: 18,
    latitude: 0,
    longitude: 0,
    markers: null,
    mapsta:false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    // 1.调用wx.getLocation系统API,获取并设置当前位置经纬度
    wx.getLocation({
      type: "gcj02", // 坐标系类型
      // 获取经纬度成功回调
      success: (res) => { // es6 箭头函数，可以解绑当前作用域的this指向，使得下面的this可以绑定到Page对象
        this.setData({  // 为data对象里定义的经纬度默认值设置成获取到的真实经纬度，这样就可以在地图上显示我们的真实位置
          longitude: res.longitude,
          latitude: res.latitude
        })
      }
    });

    // 2.设置地图控件的位置及大小，通过设备宽高定位
    wx.getSystemInfo({
      success: (res) => {
        this.setData({
          controls: [{
            id: 1,
            iconPath: '../image/location.png',
            position: {
              left: 20,
              top: res.windowHeight-150,
              width: 50,
              height: 50
            },
            clickable: true
          },
          {
            id: 2,
            iconPath: '../image/scan.png',
            position: {
              left: res.windowWidth / 2 - 45,
              top: res.windowHeight - 150,
              width: 1,
              height: 1
            },
            clickable: true
          },
          {
            id: 3,
            iconPath: '../image/marker.png',
            position: {
              left: res.windowWidth / 2 - 11,
              top: res.windowHeight / 2 - 45,
              width: 22,
              height: 45
            },
            clickable: false
          }]
        })
      }
    });

    //3.访问服务器，获得共享图书设备的位置并标记
    //目前没有较好的标记图片素材
    wx.request({
      url: 'https://www.lieyanwenhua.com/addresslist',
      data: {},
      method: 'POST',
      header: {
        "Content-Type": "application/json"
      },
      success: (res) => {
        this.setData({
          markers: res.data.data
        })
        console.log(this.data.markers)
      }
    })
    that.setData({
      carid:options.id
    })

    
    wx.request({
      url: 'https://www.lieyanwenhua.com/cardetailbyid',
      method: 'POST',
      data:{
        "id":that.data.carid
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log(res.data);
        that.setData({
          cardetail: res.data
        })
        console.log(that.data.cardetail)
      },
      fail: function () {

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
    // 1.创建地图上下文，移动当前位置到地图中心
    this.mapCtx = wx.createMapContext("Map"); // map地图组件的id：Map
    this.movetoPosition()
  },
  // 定位函数，移动位置到地图中心
  movetoPosition: function () {
    this.mapCtx.moveToLocation();
  },

  bindcontroltap: function (e) {
    var that = this; //获得当前界面副本，这一步不可缺少，在回调函数中不能成功调用自定义函数

    // 判断点击的是哪个控件 e.controlId代表控件的id，在页面加载时的第2步设置的id
    switch (e.controlId) {
      //点击定位控件
      case 1: this.movetoPosition(); break;
        
    }
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
  downtab:function(){
    var that=this;
    that.setData({
      mapsta:true
    })
  },
  uptab:function(){
    var that=this;
    that.setData({
      mapsta:false
    })
  },
  godes:function(){

  }
})