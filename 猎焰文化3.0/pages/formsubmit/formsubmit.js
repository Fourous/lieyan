// pages/entryform/entryform.js

Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: '',
    tel: '',
    id_card: '',
    address: '',
    qq: '',
    weixin: '',
  },
  show: function () {
    this.setData({ flag: false })
  },
  hide: function () {
    this.setData({ flag: true })
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
  id_card: function (e) {
    this.setData({
      id_card: e.detail.value
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
  weixin: function (e) {
    this.setData({
      weixin: e.detail.value
    })
  },
  teacher: function (e) {
    this.setData({
      teacher: e.detail.value
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

  },
  /**
   * 报名表单提交
   */
  apply: function () {
    var that = this
    console.log(this.data.name + this.data.tel + this.data.id_card + this.data.address + this.data.qq + this.data.weixin + this.data.teacher)
    console.log(this.data.address == null)
    console.log(this.data.tel == "")
    console.log(this.data.tel == '')
    //首先判断必填项是否为空，为空提示，不为空则继续下一步
    if (this.data.name == "" | this.data.tel == "" | this.data.id_card == "" | this.data.address == "") {
      console.log("this is no");
      wx.showToast({
        title: '必填项缺失',
      })
    }
    else {
        // 这里直接提交表单
console.log(this.data.name+this.data.tel+this.data.id_card+this.data.address+this.data.qq+this.data.weixin);
      wx.request({
        url: 'https://www.lieyanwenhua.com/formcorpinsert',
        data: {
          "fname":this.data.name,
          "faddress":this.data.address,
          "fwechat":this.data.weixin,
          "fqq":this.data.qq,
          "ftel":this.data.tel,
          "fidcard":this.data.id_card
        },
        method: 'POST',
        header: {
          "Content-Type": "application/json"
        },
        success: (res) => {
          console.log(res.data);
          if(res.data==true){
            wx.showToast({
              title: '提交成功',
            })
            setTimeout(function () {
              wx.navigateBack({
                delta: 1
              })
            }, 1000
            );
          }else {
            wx.showToast({
              title: '稍后再试',
            })
          
          }
          console.log(that.data.detailgood);
        }
      })

    }
  }
})