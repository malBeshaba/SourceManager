// pages/user/myOrder.js
Page({

  /**
   * Page initial data
   */
  data: {
    order_list:[1,1,1,1,1,1],
    is_success: true
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    wx.request({
      url: 'https://localhost:8080/order',
      data: {
        user_id: 0
      },
      responseType: JSON,
      success: (res) => {
        var list = res.data.data.list
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
  loadSource: function (id) {
    wx.request({
      url: 'https://localhost:8080/source',
      data: {
        id: id
      },
      responseType:JSON,
      success: (res) => {
        return res.data.data
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