var app = getApp()
Page({
  data: {
    addressInfo: null,
    touchStart: null,
    moveSpace: 0 
  },
  onShow: function () {
    this.setData({
      addressInfo: app.globalData.userdata.address
    });
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
