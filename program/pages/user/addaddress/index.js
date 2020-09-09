const app = getApp();
Page({
  data: {
    addressInfo: null
  },
  chooseAddress() {
    wx.chooseAddress({
      success: (res) => {
        this.setData({
          addressInfo: res
        })
      },
      fail(err) {
        console.log(err)
      }
    })
  },
  addAddress(){
    
   var pages = getCurrentPages();
   var prevPage = pages[pages.length - 2]; 
   wx.navigateBack({//返回
    delta: 1
  }),
    wx.request({
      url: app.globalData.baseURL+"/userInfo/address",
      method:'POST',
      data:{
        address: addressInfo
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
