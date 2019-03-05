// pages/cart/cart.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    winHeight: '',
    currentTab: 0,
    scrollLeft: 0,
    flag: true,
    id: 0,
    clientHeight: "",
    name: '',
    tel: '',
    address: '',
    qq: '',
    id: '',
    openid: "",
    off: "",
    packname:"",
    fir:true,
    goods: [
     {
       id:1,
       price:100
     },
     {
       id:2,
       price:200
     },
     {
       id:3,
       price:400
     }

    ]
  },
  // 滚动切换标签样式
  switchTab: function (e) {
    // 通过Tab定于套餐号码
    this.setData({
      currentTab: e.detail.current
    });
    this.checkCor();
    console.log("当前tab"+this.data.currentTab);
  },
  // 点击标题切换当前页时改变样式
  switchNav: function (e) {
    var that=this
    var cur = e.target.dataset.current;
    // this.setWinHeight(cur);
    if (this.data.currentTaB == cur) { return false; }
    else {
      this.setData({
        currentTab: cur
      })
    }
   console.log(that.data.currentTab);
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
  teamname: function (e) {
    this.setData({
      teamname: e.detail.value
    })
  },
  //判断当前滚动超过一屏时，设置tab标题滚动条。
  checkCor: function () {
    if (this.data.currentTab > 3) {
      this.setData({
        scrollLeft: 300
      })
    } else {
      this.setData({
        scrollLeft: 0
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    var that = this
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          clientHeight: res.windowHeight
        });
      }
    });
    wx.request({
      url: 'https://www.lieyanwenhua.com/packdetailall',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: (res) => {
        console.log(res.data);
        that.setData({
         goods: res.data
        })
        console.log(that.data.off);
      }
    })
   
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this;
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        console.log("cheng");
        that.setData({
          userInfo: res.data
        })
        console.log("jia");
      },
    });
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
    });
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    // var that=this
    // wx.request({
    //   url: 'https://www.lieyanwenhua.com/testform',
    //   data: {
    //     openid: that.data.openid
    //   },
    //   method: 'POST',
    //   header: {
    //     "Content-Type": "application/x-www-form-urlencoded"
    //   },
    //   success: (res) => {
    //     console.log(res.data);
    //     that.setData({
    //       off: res.data
    //     })
    //     console.log(that.data.off);
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
  confirm:function(){
    // 这里签署协议
  var that=this
  that.setData({
    fir:!that.data.fir
  })
  },
  goto:function(){
    //  去协议
  wx.navigateTo({
    url: '../resume/resume',
  })
  },
  navigateToQuestion: function (e) {
    wx.navigateTo({
      url: '../question/question'
    })
  },
  navigateToGood: function (e) {
    var that = this
    var type = e.currentTarget.dataset.type - 1;
    var id = e.currentTarget.dataset.id - 1;
    that.data.goods[type].good[id].flag = !that.data.goods[type].good[id].flag
    console.log(type);
    console.log(id);
    that.setData({
      goods: that.data.goods
    })
  },


  navigateToAd: function (e) {
    //console.log(e);
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../advertise/advertise?id=' + id,
    })
  },
  swiperchange: function (e) {
    var that = this
    console.log(e.detail.current)
    that.setData({
      'currentTab': e.detail.current
    })
  },
  nexttap: function () {
    var that = this
    that.setData({
      id:that.data.currentTab
    })
    console.log(this.data.name + this.data.tel + this.data.address + this.data.qq)


if(!that.data.fir){

  wx.request({
    url: 'https://www.lieyanwenhua.com/testform',
    data: {
      openid: that.data.openid
    },
    method: 'POST',
    header: {
      "Content-Type": "application/x-www-form-urlencoded"
    },
    success: (res) => {
      console.log(res.data);
      that.setData({
        off: res.data
      })
      console.log(that.data.off);
    }
  })

  // 这里判断重复报名
  if (!that.data.off) {
    wx.showToast({
      title: '您已经报名',
    })
  }
  else {
    //首先判断必填项是否为空，为空提示，不为空则继续下一步
    if (this.data.name == "" | this.data.tel == "" | this.data.address == "" | this.data.qq == "") {
      wx.showToast({
        title: '必填项缺失',
      })
    }
    else {
      if (that.data.currentTab == 2) {
        if (that.data.currentTab == 0) {
          that.setData({
            packname: "套餐1"
          })
        } else if (that.data.currentTab == 1) {
          that.setData({
            packname: "套餐2"
          })
        } else if (that.data.currentTab == 2) {
          that.setData({
            packname: "套餐3"
          })
        }
        wx.navigateTo({
          url: '../teampay/teampay?name=' + that.data.name + '&tel=' + that.data.tel + '&address=' + that.data.address + '&qq=' + that.data.qq + '&car=' + that.data.id + '&packname=' + that.data.packname + '&teamname=' + that.data.teamname + '&money=' + that.data.goods[that.data.currentTab].price
        })
      }

      else {
        if (that.data.currentTab == 0) {
          that.setData({
            packname: "套餐1"
          })
        } else if (that.data.currentTab == 1) {
          that.setData({
            packname: "套餐2"
          })
        } else if (that.data.currentTab == 2) {
          that.setData({
            packname: "套餐3"
          })
        }
        wx.navigateTo({
          url: '../formpay/formpay?name=' + that.data.name + '&tel=' + that.data.tel + '&address=' + that.data.address + '&qq=' + that.data.qq + '&car=' + that.data.id + '&packname=' + that.data.packname + '&money=' + that.data.goods[that.data.currentTab].price
        })
      }


    }

  }

}else{
  wx.showToast({
    title: '请同意协议',
  })
}



  }

})