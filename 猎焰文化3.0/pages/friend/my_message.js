var app = getApp();
Page({
  data: {
    uploadedImages: [],
    imgBoolean: true,
    content: "",
    openid: '',
    circleid:' ',
    t:3,
    imgs: [],
    ss:[]

   
  },
  onLoad: function (options) {
  
    var that = this;
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        console.log("cheng");
        that.setData({
          userInfo: res.data
        })
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

      },
    })

  },

  chooseImg() {

    let that = this;

    let len = this.data.imgs;

    if (len >= 3) {

      this.setData({

        lenMore: 1

      })





      return;

    }

    wx.chooseImage({

      success: (res) => {

        let tempFilePaths = res.tempFilePaths;

        console.log(tempFilePaths)

        let imgs = that.data.imgs;

        for (let i = 0; i < tempFilePaths.length; i++) {

          if (imgs.length <3 ) {

            imgs.push(tempFilePaths[i])

          } else {

            that.setData({

              imgs:that.data.imgs

            })

            wx.showModal({

              title: '提示',

              content: '最多只能有三张图片'

            })

            return;

          }

        }

        that.setData({

          imgs:that.data.imgs

        })

      }

    })

  },
  previewImg(e) {

    let index = e.currentTarget.dataset.index;

    let imgs = this.data.imgs;

    wx.previewImage({

      current: imgs[index],

      urls: imgs,

    })

  },

  deleteImg(e) {

    let _index = e.currentTarget.dataset.index;

    let imgs = this.data.imgs;

    imgs.splice(_index, 1);

    this.setData({

      imgs

    })

  },

  input: function (e) {
    var that=this;  
    
    that.setData({
      content:e.detail.value,  
    })
    console.log(that.data.content)
  },
  //发布按钮事件
  send: function () {
    var that = this;
    wx.showLoading({
      title: '上传中',

    })
    console.log(that.data.content)
    wx.request({
      url: 'https://www.lieyanwenhua.com/cirinsert',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      data: {
        openid: that.data.openid,
        mess: that.data.content
      },
      success: function (res) {
        var id;
        that.setData({
          id: res.data

        })
        that.data.circleid = that.data.id;

        app.globalData.flag = res.data
        console.log("成功")
        wx.hideLoading();
        console.log(that.data.circleid)
        var uploadImgCount = 0;
        console.log(that.data.imgs)
        console.log(that.data.uploadedImages)
        if(that.data.imgs.length!= 0){
          for (var i = 0, h = that.data.imgs.length; i < h; i++) {
            console.log(that.data.imgs[i])
            wx.uploadFile({
              url: 'https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/', //开 //开发者服务器的 url
              filePath: that.data.imgs[i], // 要上传文件资源的路径 String类型！！！
              name: 'file', // 文件对应的 key ,(后台接口规定的关于图片的请求参数)
              header: {
                'content-type': 'multipart/form-data'
              },
              // 设置请求的 header
              formData: {
                'key': "circle/" + res.data + "image_" + i + ".png"
              },

              // HTTP 请求中其他额外的参数
              success: function (res) {
              },
              fail: function (res) {


              }
            })
          }
        }
        
    if(that.data.imgs.length>0){
      wx.request({
        url: 'https://www.lieyanwenhua.com/cirimage',
        method: 'POST',
        header: { 'content-type': 'application/x-www-form-urlencoded' },
        data: {
          circleid: res.data,
          image1: 'https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/' + "circle/" + res.data + "image_" + 0 + ".png",
          image2: 'https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/' + "circle/" + res.data + "image_" + 1 + ".png",
          image3: 'https://lieyan-1257158697.cos.ap-shanghai.myqcloud.com/' + "circle/" + res.data + "image_" + 2 + ".png"
        },
        success: function (res) {
          wx.showToast({
            title: '发布成功',
          })
          wx.switchTab({
            url: '../friend/friend',
          })
        }
      })
    }   
        wx.showToast({
          title: '发表成功',
        },2000)
        wx.switchTab({
          url: '../friend/friend',
        })
      }
    })
    }
})