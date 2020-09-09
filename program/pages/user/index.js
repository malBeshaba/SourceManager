//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),

    id:null,
    tel:null,
    order:null,
    source:null,
    address:null,
    money:0
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }

    //获取用户信息，存在全局变量中
    const url=app.globalData.baseURL+"/userInfo"; 
    wx.request({
      url: url,
      success:  (res) => {
        console.log(res.data);
        // 赋值
        this.setData({
         tel:res.data.tel,
         order:res.data.order,
         source:res.data.source,
         address:res.data.address,
         money:res.data.money
        })
      },
      fail(err) {
        console.log(err)
      }
    })
    app.globalData.userdata.address=address,
    app.globalData.userdata.money=money,
    app.globalData.userdata.order=order,
    app.globalData.userdata.source=source

  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
