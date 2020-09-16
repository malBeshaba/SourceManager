const app = getApp()
Page({
  data: {
    addressInfo: null,
  },
  onShow: function () {
    this.setData({
      addressInfo: app.globalData.userdata.address
    });
    },
    onLoad: function(e) {
      wx.request({
        url: app.globalData.baseURL + '/user/address',
        data: {
          username: app.globalData.userInfo.nickName
        },
        success: res => {
          // this.setData
        }
      })
    },
  delete: function (e){
        wx.request({
          url: app.globalData.baseURL+"/userInfo/address",
          method:'delete',
          success:  (res) => {
            console.log("success");
          },
          fail(err) {
            console.log(err)
          }
        })
  }
  
})
