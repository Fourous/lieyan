// pages/studycar/study.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bgimg:"",
    coach:null,
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
    var that=this
    wx.request({
      url: 'https://www.lieyanwenhua.com/coachall',
      method: 'POST',
      data: {
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log("这里是教练的信息")
        console.log(res.data.coachall)
        that.setData({
          coach: res.data.coachall
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
  To_teacher_detail:function(e)
  {
    var id = e.currentTarget.dataset.id;
    console.log(e),
    wx.navigateTo({
      url: '../teacherdetail/teacherdetail?tid='+id,
    })
  },
  //这里的官方方法改变，需要字符串加起来
  //like是点赞，unlike是踩，点击评论跳到另一个界面
  likereact:function(e){
    var that = this;
    console.log(e.target.dataset.id)
    var id = e.target.dataset.id 
 
    if(id==2)
    {
      console.log(that.data.coach[0].like)
      that.data.coach[0].like = that.data.coach[0].like ? 0 : 1;
      var l = "coach[0].like";
      that.setData({
        [l]: that.data.coach[0].like
      })

    }

    if(id==1){
      console.log(that.data.coach[1].like)
      that.data.coach[1].like = that.data.coach[1].like ? 0 : 1;
      var l = "coach[1].like";
      that.setData({
        [l]: that.data.coach[1].like
      })
    }


  },



})