// pages/personal/changeone/changeone.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid:"",
    value:"",
    message:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    var that = this
    that.setData({
      message:options.nickname
    })
    wx.getStorage({
      key: 'openid',
      success: function (res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid: res.data
        })
        console.log(that.data.openid)
      },
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
  getmes: function (e) {
    var message = e.detail.value;
    console.log("信息")
    console.log(e.detail.value)
    this.data.value = e.detail.value
    console.log(this.data.value)
  },

  save:function(){
    console.log("保存退出");
    var that=this;
    if(that.data.value==null||that.data.value==""){
wx.showToast({
  title: '不能为空',
  icon:"loading"
})
    }else{
      console.log("上传数据");
      wx.request({
        url: 'https://www.lieyanwenhua.com/changeusername',
        method: 'POST',
        data: {
          'openid': that.data.openid,
          "name":that.data.value
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success: function (res) {
          console.log(res);
          if(res.data==true){
            wx.showToast({
              title: '修改成功',
            })
          }else{
            wx.showToast({
              title: '修改失败',
              icon:"loading"
            })
          }
        
          var pages = getCurrentPages();
          var tempPage = pages[pages.length - 2];
        wx.navigateBack({
          
        })
        },
        fail: function (res) {
          console.log(res);
        }
      })
    }
    }
})