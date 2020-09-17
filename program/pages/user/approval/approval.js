// pages/user/approval/approval.js
const app = getApp();
const orderList = '/order/getBySourceId';
const approval = '/order/checkout'
Page({

  /**
   * Page initial data
   */
  data: {
    source_id: 0,
    order_list:[]
  },
  refuse: function (e) {
    wx.request({
      url: app.globalData.baseURL+approval +'?order_id='+e.currentTarget.id+'&is_agreed='+0,
     
      method: "PUT",
      success: res => {
        wx.showToast({
          title: '已拒绝',
          icon: 'succes',
          duration: 1000,
          mask:true
        })
      }
    })
   
  },
  allow: function (e) {
    wx.request({
      url: app.globalData.baseURL+approval +'?order_id='+e.currentTarget.id+'&is_agreed='+1,
     
      method: "PUT",
      success: res => {
        wx.showToast({
          title: '已同意',
          icon: 'succes',
          duration: 1000,
          mask:true
        })
      }
    })
    
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    var id = options.id;
    wx.request({
      url: app.globalData.baseURL + orderList,
      data: {
        source_id: id
      },
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