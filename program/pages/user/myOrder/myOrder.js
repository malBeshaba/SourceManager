// pages/user/myOrder.js
Page({

  /**
   * Page initial data
   */
  data: {
    order_list:[1,1,1,1,1,1],
    source:[],
    is_success: true
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    console.log('onload')
    console.log(options.name)
    wx.request({
      url: 'http://localhost:8080/order/getorder?username='+options.name,
      success: (res) => {
        var list = res.data.data
        console.log(list)
        this.setData({
          order_list: list,
          is_success: true
        })
      },
      fail: (err) => {
        console.log(err)
      }
    })
  },

  /**
   * Lifecycle function--Called when page is initially rendered
   */
  onReady: function () {

  },

  /**
   * Lifecycle function--Called when page show
   */
  onShow: function () {

  },

  /**
   * Lifecycle function--Called when page hide
   */
  onHide: function () {

  },

  /**
   * Lifecycle function--Called when page unload
   */
  onUnload: function () {

  },

  /**
   * Page event handler function--Called when user drop down
   */
  onPullDownRefresh: function () {

  },

  /**
   * Called when page reach bottom
   */
  onReachBottom: function () {

  },

  /**
   * Called when user click on the top right corner to share
   */
  onShareAppMessage: function () {

  }
})