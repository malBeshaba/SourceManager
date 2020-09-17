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
    money:app.globalData.money
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  // onShow() { 
  //   this.onLoad();
  //   console.log("刷新")
  // },

  onLoad: function () {
    this.setData({
      money: app.globalData.money
    })

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
          console.log('begin');
        }
      })
      
    }

  },
  login: function(e) {
    var that = this;
    wx.request({
      url: app.globalData.baseURL + '/user/login',
      data: {
        username: that.data.userInfo.nickName
      },
      success: (res) => {
        if (res.data.code == 0) {
          console.log('success')
        }
      },
      fail: (res) => {
        console.log('fail')
      }
    })
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  onShow: function () {
    let pages = getCurrentPages();
    let currPage = pages[pages.length - 1];
    //当前页的options，啥意思呢，就是你可能某个函数需要刷新，但是他的参数正好是传过来的参数
    console.log(currPage.options); 
    this.setData({
     money: app.globalData.money
    })
    }
})
