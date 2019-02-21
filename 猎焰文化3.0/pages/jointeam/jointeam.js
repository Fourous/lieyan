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
    userInfo: "",
    openid:"",
    teamid:""
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
    var that=this
    console.log(options)
    that.setData({
      teamid:options.teamid
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
    console.log(this.data.name + this.data.tel + this.data.address + this.data.qq + this.data.weixin + this.data.teacher)
    console.log(this.data.address == null)
    console.log(this.data.tel == "")
    console.log(this.data.tel == '')
    //首先判断必填项是否为空，为空提示，不为空则继续下一步
    if (this.data.name == "" | this.data.tel == ""  | this.data.address == "") {
      console.log("this is no");
      wx.showToast({
        title: '必填项缺失',
      })
    }
    else {
      // 这里直接提交表单
      console.log(this.data.name + this.data.tel + this.data.id_card + this.data.address + this.data.qq + this.data.weixin);
      wx.login({
        success: function (res) {
          console.log("这里开始请求");
          wx.request({
            url: 'https://www.lieyanwenhua.com/code',
            data: {
              code: res.code,
            },
            method: 'POST',
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            success: function (res) {
              console.log("这里展示openid"+res.data.openid);
              that.setData({
                openid:res.data.openid
              })

              wx.request({
                url: 'https://www.lieyanwenhua.com/testin',
                data: {
                  teamid:that.data.teamid,
                  openid:that.data.openid
                },
                method: 'POST',
                header: {
                  "Content-Type": "application/x-www-form-urlencoded"
                },
                success: (res) => {
                console.log(res.data);
                 if(res.data==1){
                    wx.showToast({
                      title: "检测到您参加其他战队"
                    })
                 }
                 else if(res.data==2){
                   wx.showToast({
                     title: "人数超过"
                   })
                 }
                 else if(res.data==3){
                   wx.showToast({
                     title: "不存在战队"
                   })
                 }
                else if(res.data==4){
                   wx.request({
                     url: 'https://www.lieyanwenhua.com/wxPay',
                     data: {
                       'openid': that.data.openid,
                       'body': that.data.name,
                       'money': 1
                     },
                     method: 'POST',
                     header: {
                       "Content-Type": "application/x-www-form-urlencoded"
                     },
                     success: function (res) {
                       console.log(res);
                       console.log(res.data.timeStamp)
                       wx.requestPayment({
                         timeStamp: res.data.timeStamp,
                         //记住，这边的timeStamp一定要是字符串类型的，不然会报错，我这边在java后端包装成了字符串类型了
                         nonceStr: res.data.nonceStr,
                         package: res.data.package,
                         signType: 'MD5',
                         paySign: res.data.paySign,
                         success: function (event) {
                           // success   
                           wx.request({
                             url: 'https://www.lieyanwenhua.com/teamgetin',
                             data: {
                               "teamid": that.data.teamid,
                               "openid": that.data.openid,
                               "fname": that.data.name,
                               "address": that.data.address,
                               "ftel": that.data.tel,
                               "fpack": 3
                             },
                             method: 'POST',
                             header: {
                               "Content-Type": "application/x-www-form-urlencoded"
                             },
                             success: (res) => {
                               console.log(res.data);
                               if (res.data == 4) {
                                 wx.showToast({
                                   title: '加入战队成功',
                                   duration: 2000
                                 })
                               }
                             }
                           })
                           console.log(event);
                           wx.showToast({
                             title: '支付成功',
                             icon: 'success',
                             duration: 2000
                           });
                           wx.redirectTo({
                             url: '../directlogin/directlogin',
                           })
                           wx.showToast({
                             title: '报名成功',
                           })
                         },
                         fail: function (error) {
                           // fail   
                           console.log("支付失败")
                           console.log(error)
                           wx.showToast({
                             title: '加入失败',
                           })
                         },
                         complete: function () {
                           wx.redirectTo({
                             url: '../directlogin/directlogin',
                           })
                           // complete   
                           console.log("pay complete")
                         }
                       });
                     }
                   });
                }
                 
                }
                
               
              })

       
            },
            // fail: function () {
            //   console.log('请求openID失败');
            //   wx.showToast({
            //     title: '服务器请求失败',
            //   })
            // }
          })
        },
        fail:function(){

        }
      })

    }
  }
})