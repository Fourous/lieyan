// pages/formpay/formpay.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    money:null,
    name: null,
    idcard: null,
    tel: null,
    address: null,
    qq: null,
    packname: null,
    car: null,
    teamname:null,
    openid:"",
    casArray: ['一对一学车', '四人学车', '团购'],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    that.setData({
      name: options.name,
      tel: options.tel,
      address: options.address,
      qq: options.qq,
      packname: options.packname,
      car: options.car,
      teamname: options.teamname,
      money:options.money
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that = this;
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
  submit: function () {
    var that = this
    // 这里不一样，需要进行填充抱团处理


    // wx.request({
    //   url: 'https://www.lieyanwenhua.com/forminsert',
      // data: {
      //   'fname': that.data.name,
      //   'ftel': that.data.tel,
      //   'faddress': that.data.address,
      //   'fqq': that.data.qq,
      //   'fpack': that.data.car
      // },
      // header: {
      //   'content-type': 'application/json'
      // },
      // method: 'POST',
      // success: function (res) {
        // if (res.data.formdetail == true) {
          //填写表单成功则吊起支付，吊支付成功之后才可以提示报名成功

          // *****


          wx.login({
            success: function (res) {
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
                  console.log(res.data.openid);
                  wx.request({
                    url: 'https://www.lieyanwenhua.com/wxPay',
                    data: {
                      'openid': res.data.openid,
                      'body': that.data.name,
                      'money': that.data.money*100
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
                          // console.log(event);
                          // wx.showToast({
                          //   title: '支付成功',
                          //   icon: 'success',
                          //   duration: 2000
                          // });
                          wx.request({
                            url: 'https://www.lieyanwenhua.com/teamcreate',
                            data: {
                              "openid": that.data.openid,
                              "teamname": that.data.teamname,
                              "fname": that.data.name,
                              "address": that.data.address,
                              "ftel": that.data.tel,
                              "fpack": that.data.packname
                            },
                            method: 'POST',
                            header: {
                              "Content-Type": "application/x-www-form-urlencoded"
                            },
                            success: (res) => {
                              console.log(res.data);
                              that.setData({
                                flag: res.data
                              })
                              console.log(that.data.flag);
                            }
                          })
                          // wx.showToast({
                          //   title: '创建战队成功',
                          //   duration: 2000
                          // })
                          wx.showModal({
                            title: '猎焰提示您',
                            content: '请到个人中心-我的组团中查看',
                            success(res) {
                              if (res.confirm) {
                                wx.navigateBack({
                                  delta: 3
                                });
                              } else if (res.cancel) {
                                wx.navigateBack({
                                  delta: 3
                                });
                              }
                            }
                          })
                         
                          // wx.showToast({
                          //   title: '报名成功',
                          // })
                         
                        },
                        fail: function (error) {
                          // fail   
                          console.log("支付失败")
                          console.log(error)
                          wx.showToast({
                            title: '支付失败',
                          })
                        },


                      
                        complete: function () {
                          
                          
                          // complete
  
                          console.log("pay complete")
                        }
                      });
                    }
                  });
                },
                fail: function () {
                  console.log('请求openID失败');
                  wx.showToast({
                    title: '请求服务器失败',
                    duration:2000
                  })
                }
              })
            }
          })

        // }

      // },
      // fail: function (res) {
      //   wx.showToast({
      //     title: '报名失败',
      //   })
      // }
  
    // })
  },

  bindCasPickerChange: function (e) {
    console.log('乔丹选的是', this.data.casArray[e.detail.value])

    this.setData({
      index: e.detail.value,
      body: this.data.casArray[e.detail.value]
    })

  },



})