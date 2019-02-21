// pages/studycardetail/studycardetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cardetail:null,
    userInfo:""
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
    var that = this;
    // var that = this
    
    wx.request({
      url: 'https://www.lieyanwenhua.com/cardetailall',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log(res.data);
        that.setData({
          cardetail:res.data
        })
        console.log(that.data.cardetail)
      },
      fail: function () {
      
      }
    })
    console.log(that.data.cardetail)
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
  To_cardetail_detail: function (e) {
    var that=this;
    var id = e.currentTarget.dataset.id;
    var lot;
    var lon;
    var title;
    wx.request({
      url: 'https://www.lieyanwenhua.com/addressbyid',
      data: {
        id:id
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res);
        that.setData({
          lot: res.data.latitude,
          lon: res.data.longitude,
          title:res.data.title
        })
        console.log(that.data.lot);
        console.log(that.data.lon);
        console.log(that.data.title);
      }
    })
    // 这里直接定位就行，调用内部接口
    wx.getLocation({//获取当前经纬度
      type: 'wgs84', //返回可以用于wx.openLocation的经纬度，官方提示bug: iOS 6.3.30 type 参数不生效，只会返回 wgs84 类型的坐标信息  
      success: function (res) {
        wx.openLocation({//使用微信内置地图查看位置。
          latitude: that.data.lot,//要去的纬度-地址
          longitude: that.data.lon,//要去的经度-地址
          name: that.data.title,
          address: that.data.title
        })
      }
    })


    // console.log(e);
    // wx.navigateTo({
    //   url: '../cardetailone/cardetailone?id='+id,
    // })
    
  },
})