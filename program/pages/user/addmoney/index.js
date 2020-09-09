const app = getApp()
Page({
  data: {
    money:0
  },
  getMoney: function (e) {
      this.setData({
          money: e.detail.value
      })
  },
  sendMoney:function (e) {
    wx.request({
      url: app.globalData.baseURL+"/userInfo/money",
      method:'POST',
      data:{
        money:money
      },
      success:  (res) => {
        console.log("success");
      },
      fail(err) {
        console.log(err)
      }
    })
  }
})
