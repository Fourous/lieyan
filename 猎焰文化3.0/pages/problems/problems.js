// pages/cart/cart.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    winHeight: '',
    currentTab: 0,
    scrollLeft: 0,
    flag:true,
    id:0,
    clientHeight:"",
    goods: [
      
      {

      good: [
        {
          typeid:1,
          id:1,
          flag:true,
          title: "报名后多久有工作人员联系？",
          answer:"报名后24小时内会有工作人员联系，请同学电话保持畅通，紧急的同学可以拨打15871722095"
      },

      {
        typeid: 1,
        id:2,
        flag: true,
        title: "学车分为哪几个阶段？",
        answer: "体检、科目一（理论考试）、科目二（场地驾驶技能考试）、科目三（机动车驾驶人考试中道路驾驶技能）、科目四（理论考试）"
     
      },
        {
          typeid: 1,
          id:3,
          flag: true,
          title: "我想参观训练场找谁带领？",
          answer: "想要参观训练场地，可以拨打客服电话进行邀约"
        },
        
      ]
    }, 
    
    
    
    {
      good: [{
        typeid: 2,
        id:1,
        flag: true,
        title: "报名费用可以优惠吗？",
        answer: "凡是通过学车管家报名学习驾考的学员，都可以享受学车管家平台当季的特色活动，享受优惠"
      },
      {
        typeid: 2,
        id:2,
        flag: true,
        title: "交了报名费用后，后续还会再交钱吗？",
        answer: "凡是报名成功后，后续学车过程中一律不再收费，严禁教练向学员收取费用，一经发现严肃处理"
      },
        {
          typeid: 2,
          id:3,
          flag: true,
          title: "补考缴费流程？",
          answer: "可以使用支付宝＞城市服务＞车主-网上车管所＞车架管缴费，选择驾驶证业务进行缴费也可以联系相关考务人员协助缴费"
        },
      ]
    },

      {
        good: [
          {
            typeid: 3,
            id:1,
            flag: true,
            title: "体检需要准备什么材料？",
            answer: "身份证原件与复印件"
        },
        {
          typeid: 3,
          id:2,
          flag: true,
          title: "体检主要检测哪些内容？",
          answer: "视力，有无红绿色盲，五指健全"
        },
          {
            typeid: 3,
            id:3,
            flag: true,
            title: "体检包接送吗？",
            answer: "联系相关考务人员，统一进行接送"
          },
          {
            typeid: 3,
            id:4,
            flag: true,
            title: "体检后多久可以预约科目一考试？",
            answer: "正常完成体检全过程的同学，需要7-10个工作日审核档案，审核通过出来流水号后才可预约科目一考试"
          },
        ]
      },


      {
        good: [{
          typeid: 4,
          id:1,
          flag: true,
          title: "考试有接送吗？",
          answer: "科目一~科目四，全程会有考务人员进行接送。"
        },
        {
          typeid: 4,
          id:2,
          flag: true,
          title: "想要取消考试怎么办？",
          answer: "学员联系考务人员查询约考进度，考务人员会根据学员的不同状态反馈学员不同的解决办法。"
        },
          {
            typeid: 4,
            id:3,
            flag: true,
            title: "考试的条件是什么？",
            answer: "熟练掌握考试科目的知识与技能，携带身份证。"
          },

        ]
      },



      {
        good: [{
          typeid: 5,
          id:1,
          flag: true,
          title: "如何绑定与更换教练？",
          answer: "学员报名成功后，工作人员将在1-3个工作日内安排其校区附近的训练场地与教练，如果在学车过程中对教练服务不满意可以通过平台-个人页面更换教练"
        },
        {
          typeid: 5,
          id:2,
          flag: true,
          title: "教练会对学员进行收费吗？",
          answer: "一律不会，一经发现，严肃处理"
        },

        ]
      },

    
    ]
  },
  // 滚动切换标签样式
  switchTab: function (e) {
    this.setData({
      currentTab: e.detail.current
    });
    this.checkCor();
  },
  // 点击标题切换当前页时改变样式
  switchNav: function (e) {
    var cur = e.target.dataset.current;
    // this.setWinHeight(cur);
    if (this.data.currentTaB == cur) { return false; }
    else {
      this.setData({
        currentTab: cur
      })
    }
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
  navigateToQuestion: function (e) {
    wx.navigateTo({
      url: '../question/question'
    })
  },
  navigateToGood: function (e) {
    var that=this
    var type = e.currentTarget.dataset.type-1;
    var id = e.currentTarget.dataset.id-1;
    that.data.goods[type].good[id].flag = !that.data.goods[type].good[id].flag
    console.log(type);
    console.log(id);
    that.setData({
      goods: that.data.goods
    })
  },

  // setWinHeight: function (current) {
  //   var len = this.data.goods[current].good.length;
  //   var num;
  //   if (len % 2 == 1) {
  //     num = ((len - 1) / 2) + 1;
  //   } else {
  //     num = len / 2;
  //   }
  //   this.data.winHeight = num * 370;
  //   this.setData({
  //     winHeight: this.data.winHeight
  //   })
  // },

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
  }

})