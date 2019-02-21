// pages/morecomment/morecomment.js
var util = require("../../utils/util.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    friend: {
      circleid: 1,
      nickname: "nihao",
      avatarurl: "",
      time: "2000-00-00 00-00-00",
      image1: "",
      image2: "",
      image3: "",
      mess: "test",
      like: 1,
      comment: []
    },
    limit: 0,
    textdata: "",
    addcomment:[],
    userInfo:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    console.log(options)
    wx.getStorage({
      key: 'userInfo',
      success: function(res) {
        console.log("cheng");
        that.setData({
          userInfo: res.data
        })
      },
    });
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        console.log(res)
        console.log(res.data)
        that.setData({
          openid: res.data
        })

      },
    });
    var circleid = options.id;
    wx.request({
      url: 'https://www.lieyanwenhua.com/getcircleid',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        circleid: circleid
      },
      success: function(res) {
        console.log(res)
        that.data.friend = res.data;
        that.setData({
          friend: that.data.friend
        });
      }
    })
    console.log(that.data.friend)
    wx.request({
      url: 'https://www.lieyanwenhua.com/commentmore',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        limit: that.data.limit,
        circleid: circleid
      },
      method: 'POST',
      success: function(res) {
        console.log(res)
        that.data.friend.comment = res.data;
        that.setData({
          friend: that.data.friend,
          limit: that.data.friend.comment.length
        })
        console.log(that.data.friend)
      }
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {
    var that = this
   
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    wx.stopPullDownRefresh();
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
    wx.showLoading({
      title: '正在火速加载！',
    })
    var that = this;
    that.data.limit = that.data.friend.comment.length;
    that.setData({
      limit: that.data.limit
    });
    wx.request({
      url: 'https://www.lieyanwenhua.com/commentmore',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        limit: that.data.limit,
        circleid: that.data.friend.circleid
      },
      method: 'POST',
      success: function(res) {
        console.log(res)
        if (res.data.length == 0) {
          wx.showToast({
            title: '暂无更多评论！',
          })
        } else {
          for (var i = 0; i < res.data.length; i++) {
            that.data.addcomment = res.data[i];
            that.data.friend.comment.push(that.data.addcomment)
          }
          console.log(that.data.friend)
          that.setData({
            friend: that.data.friend,
            limit: that.data.friend.comment
          });
        }
        wx.hideLoading();
      }

    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  likereact: function(e) {

    var that = this;
    console.log('try')
    console.log(e.target.dataset.id)
    var id = e.target.dataset.id;
    //var index = e.target.dataset.i;

    //console.log(that.data.stus[id].like)
    that.data.friend.like = that.data.friend.like ? 0 : 1;
    //var l = "stus[" + id + "].like";
    that.setData({
      friend: that.data.friend
    })
  },
  liuyan: function(e) {
    var that = this;
    console.log(e);
    var comment = e.detail.value;
    that.setData({
      textdata: comment
    })
  },
  fabiao: function(e) {
    var that = this;
    console.log(e);
    var comment = that.data.textdata;
    console.log(comment)
    //var index = e.currentTarget.dataset.i;
    var cirid = e.currentTarget.dataset.id;
    if (comment == '') {
      wx.showToast({
        title: '留言内容不能为空',
      })
    } else {
      var com = {
        nickname: that.data.userInfo.nickName,
        avatarurl: that.data.userInfo.avatarUrl,
        commentime: util.formatTime(new Date()),
        mess: comment
      }
      that.data.friend.comment.push(com);
      that.setData({
        friend: that.data.friend,
        textdata: ''
      })
      wx.request({
        url: 'https://www.lieyanwenhua.com/circominsert',
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        data: {
          circleid: cirid,
          openid: that.data.userInfo.openid,
          comment: comment
        },
        success: function(res) {
          console.log(res)
          if (res.data) {
            wx.showToast({
              title: '留言成功',
            })
          }
        }
      })
    }
  }
})