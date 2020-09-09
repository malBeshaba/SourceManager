var app = getApp()
Page({
  data: {
    addressInfo: null
  },
  onShow: function () {
    this.setData({
      address: app.globalData.userdata.address
    });
    }
  
})
