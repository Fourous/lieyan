// pages/teacherdetail/teacherdetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      '../image/forback.png',
    ],
    tid:null,
    time:"2018.9.8",
    message: "在这发表您的评论",
    flag: true,
    teachers: null,
    comments: null,
    valuemsg:null,
    openid:null
  },
  show: function () {
    this.setData({ flag: false })
  },
  hide: function () {
    this.setData({ flag: true })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.tid)
    var that=this
    that.setData({
      tid:options.tid
    })
    wx.request({
      url: 'https://www.lieyanwenhua.com/coach_comment',
      header: { "Content-Type": "application/x-www-form-urlencoded" },
      method: 'POST',
      data: {
        tid: that.data.tid
      },
      success: function(res){
        console.log(res)
        var comments= res.data.comment_user;
        that.setData({
          comments: comments
        })
      }
    })
  },
  commentcome: function () {
    var that = this;
    wx.request({
      url: 'https://www.lieyanwenhua.com/coach_comment',
      method: 'POST',
      data: {
        "tid": that.data.tid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data);
        that.setData({
          comments: res.data.comment_user
        })
      },
      fail: function (res) {
        console.log(res);
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
    wx.request({
      url: 'https://www.lieyanwenhua.com/coach_single',
      method: 'POST',
      data: {
        "tid": that.data.tid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data);
        that.setData({
          teachers:res.data.coach
        })
        console.log(that.data.teachers)

      },
      fail: function (res) {
        console.log(res);
      }
    })
that.commentcome();
      // 在这里通过openid请求评论人物的头像和昵称信息
    // wx.request({
    //   url: 'https://www.lieyanwenhua.com/userqueryByid',
    //   method: 'POST',
    //   data: {
    //     "openid": 
    //   },
    //   header: {
    //     'content-type': 'application/x-www-form-urlencoded'
    //   },
    //   success: function (res) {
    //     console.log(res.data);
    //     that.setData({
    //       comments: res.data.comment_user
    //     })
    //   },
    //   fail: function (res) {
    //     console.log(res);
    //   }
    // })


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

  order_teacher: function () {
    var that=this;
    console.log(that.data.tid);
    wx.navigateTo({
      url: '../orderteacher/orderteacher?id='+that.data.tid,
    })
  },
  bindinput: function (e) {
    var that = this
    // 获取输入框的内容
    var value = e.detail.value;
    // 获取输入框内容的长度
    var len = parseInt(value.length);
    //最少字数限制
    that.setData({
      valuemsg: value,
    })
    console.log(that.data.valuemsg);
  },
  input_button:function(){
    console.log("触发这个按钮");
    var that=this;
    if (that.data.valuemsg == null || that.data.openid == undefined||that.data.openid==null){
      wx.showToast({
        title: '没有内容哦',
        icon:"loading"
      })
    }else{
      wx.request({
        url: 'https://www.lieyanwenhua.com/comment_insert',
        method: 'POST',
        data: {
          "tid": that.data.tid,
          "openid": that.data.openid,
          "comment": that.data.valuemsg
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success: function (res) {
          //这里评论成功会返回1
          if (res.data == true) {
            wx.showToast({
              title: '发表成功',
            })
            that.hide();
            that.commentcome();
          } else {
            wx.showToast({
              title: '发表失败',
              icon: "loading"
            })
            that.hide();
          }
        },
        fail: function (res) {
          console.log(res);
        }
      })
    }
    //这里是发布评论的地方，发布评论最好是在此重拉一次评论数据
 
  }
})



