// pages/user/approval/approval.js
Page({

  /**
   * Page initial data
   */
  data: {
    source_id: 0,
    order_list:[]
  },
  refuse: function (e) {
    wx.showToast({
      title: '已拒绝',
      icon: 'succes',
      duration: 1000,
      mask:true
    })
  },
  allow: function (e) {
    wx.showToast({
      title: '已同意',
      icon: 'succes',
      duration: 1000,
      mask:true
    })
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    var id = options.id;
    wx.request({
      url: '',
      responseType:JSON,
      success: (res) => {
        this.setData({
          order_list: res.data.data
        })
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