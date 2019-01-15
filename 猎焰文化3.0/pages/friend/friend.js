// pages/friend/friend.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    'inform': '一对一学车”，享受VIP教学！',
    flag: 'true',
    imgUrls: [],
    circleid: 5,
    content: '',
    openid: '',
    comment: [],
    textdata: '',
    friend: [],
    limit:0,
    addfriend: {
      circleid: 1,
      nickname: "nihao",
      avatarurl: "",
      time: "2000-00-00 00-00-00",
      image1: "",
      image2: "",
      image3: "",
      mess: "test",
      like: 1,
      comment: [{
        nickname: "nihao",
        mess: "text"
      }, {
        nickname: "nihao",
        mess: "text"
      }, {
        nickname: "nihao",
        mess: "text"
      }]
    }



  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;

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
    wx.request({
      url: 'https://www.lieyanwenhua.com/circleone',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data:{
        limit:that.data.limit
      },
      method: 'POST',
      success: function(res) {
        console.log(res)
        that.data.friend = res.data;
        that.setData({
          friend: that.data.friend,
          limit: that.data.friend.length
        });
      }
    })
    console.log("1")


  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {



  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    var that = this
    var array = new Array()

    for (let i = 1; i < 4; i++) {
      let url = "https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/advertising/top" + i + ".png"
      wx.downloadFile({
        url: url,
        success: (res) => {
          console.log(res)
          if (res.statusCode == 200) {
            let temp = res.tempFilePath
            array[i - 1] = temp
            that.setData({
              imgUrls: array
            })
          }
        }
      })

    }

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
      title: '玩命加载中...',
    })
    var that= this;
    that.data.limit= that.data.friend.length;
    that.setData({
      limit: that.data.limit
    });
    wx.request({
      url: 'https://www.lieyanwenhua.com/circleone',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        limit: that.data.limit
      },
      method: 'POST',
      success: function (res) {
        console.log(res)
        if(res.data.length== 0){
          wx.showToast({
            title: '暂无更多说说！',
          })
        }else{
          for (var i = 0; i < res.data.length; i++) {
            that.data.addfriend = res.data[i];
            that.data.friend.push(that.data.addfriend)
          }
          console.log(that.data.friend)
          that.setData({
            friend: that.data.friend
          });
        }
        wx.hideLoading();
      }
    })
    // that.data.friend.push(that.data.addfriend);
    // that.setData({
    //   friend: that.data.friend
    // });
    // wx.hideLoading();
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
    var index = e.target.dataset.i;

    //console.log(that.data.stus[id].like)
    that.data.friend[index].like = that.data.friend[index].like ? 0 : 1;
    //var l = "stus[" + id + "].like";
    that.setData({
      friend: that.data.friend
    })
  },
  /*
  控制评论区
  */
  show: function() {
    this.setData({
      flag: false
    })

  },

  showad: function(e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../advertise/advertise?id=' + id,
    })
    wx.showToast({
      title: '广告位招标！',
    })

  },
  to_message: function() {
    wx.navigateTo({
      url: '../friend/my_message',
    })
  },
  liuyan: function(e) {
    var that = this;
    console.log(e);
    var comment = e.detail.value;
    var index = e.currentTarget.dataset.i;
    var cirid = e.currentTarget.dataset.id;
    if (comment == '') {
      wx.showToast({
        title: '留言内容不能为空',
      })
    } else {
      var com = {
        nickname: that.data.userInfo.nickName,
        comment: comment
      }
      that.data.friend[index].comment.push(com);
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
    // that.setData({
    //   content:e.detail.value,
    //   circleid:e.target.dataset.id
    // })
    // var com={
    //   nick:that.data.userInfo.nickName,
    //   comm:e.detail.value
    // }
    // that.data.comment.push(com);
    // that.setData({
    //   comment:that.data.comment
    // });
    // console.log(e.detail.value)
    // console.log(e)
    // // var t
    // that.setData({
    //   t: that.data.content,
    //   textdata: ''
    // })
    // that.data.comment[that.data.circleid] = that.data.t
    // wx.request({
    //   url: 'https://www.lieyanwenhua.com/circominsert',
    //   method: 'POST',
    //   header: { "Content-Type": 'application/json' },
    //   success: function () {
    //     that.setData({
    //       circleid: that.data.circleid,
    //       openid: that.data.openid,
    //       comment: that.data.comment,
    //     })
    //     console.log("成功！")
    //   },

    // })
    // wx.showToast({
    //   title: '留言成功',
    // })
  },
  ly_btn: function() {
    var that = this
    var t
    that.setData({
      t: that.data.content,
      textdata: ' '
    })
    that.data.comment[that.data.circleid] = that.data.t;
    wx.request({
      url: 'https://www.lieyanwenhua.com/circominsert',
      method: 'POST',
      header: {
        "Content-Type": 'application/json'
      },
      success: function() {
        that.setData({
          circleid: that.data.circleid,
          openid: that.data.openid,
          comment: that.data.comment,
        })
        console.log("成功！")
      },

    })
    wx.showToast({
      title: '留言成功',
    })


  },
  tomore: function(res) {
    var id= res.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../morecomment/morecomment?id=' + id,
    })
  }
})