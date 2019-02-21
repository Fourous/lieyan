// pages/personal/feedback/feedback.js
Page({

  /**
   * 页面的初始数据
   */
  
  data: {
    imgUrls: [
      '../../image/forback.png',
    ],
    texts: "至少5个字",
    min: 5,//最少字数
    max: 140, //最多字数 
    message: "在这里输入您想输入的内容，匿名提交您想要的内容",
    flag: true,
    feedbacks:null,
    value:"",
    len:0,
    userInfo:""
  },
   //字数限制  
  bindinput: function (e) {
    var that=this
    // 获取输入框的内容
    var value = e.detail.value;
    // 获取输入框内容的长度
    var len = parseInt(value.length);
    //最少字数限制
    that.setData({
      value:value,
      len:len
    })
  },
  

  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
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
    var that = this
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    //反馈建议获取
    var that=this
    wx.request({
      url: 'https://www.lieyanwenhua.com/feedall',
      method: 'POST',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
       
      },
      success: function (res) {
        console.log(res.data.feedback);
        that.setData({
          feedbacks:res.data.feedback
        })
      },
      fail: function (res) {
        console.log(res);
      }
    })

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
  //这里的官方方法改变，需要字符串加起来
  //like是点赞，unlike是踩，点击评论跳到另一个界面
  likereact: function (e) {
    var id = e.target.dataset.id;
    this.data.feedbacks[id].like = this.data.feedbacks[id].like ? 0 : 1;
    var l = "feedbacks[" + id + "].like";
    this.setData({
      [l]: this.data.feedbacks[e.target.dataset.id].like
    })
  },
  unlikereact: function (e) {
    var id = e.target.dataset.id;
    this.data.feedbacks[id].unlike = this.data.feedbacks[id].unlike ? 0 : 1;
    var l = "feedbacks[" + id + "].unlike";
    this.setData({
      [l]: this.data.feedbacks[e.target.dataset.id].unlike
    })
  },
  show: function () {
    this.setData({ flag: false })
  },
  hide: function () {
    var that=this
    console.log("这里点击提交")
    console.log(this.data.texts)
    console.log(that.data.value)
    console.log(that.data.len)
    if(that.data.len>=5 && that.data.len<150){
      // 反馈建议书写
      console.log("tiaochulai ")
      wx.request({
        url: 'https://www.lieyanwenhua.com/feedinsert',
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        data: {
          'openid': that.data.openid,
          'fbtxt': that.data.value
        },
        success: function (res) {
          console.log(res.data);
          if (res.data = true) {
            wx.showToast({
              title: '发表成功',
            })
          }
        },
        fail: function (res) {
          console.log(res);
        }
      })
      this.setData({ flag: true })
    }
    else if(that.data.len<5){
wx.showToast({
  title: '字数不足5',
})
    }else if(that.data.len>150){
      wx.showToast({
        title: '字数超出',
      })
    }
    
  },

  

})