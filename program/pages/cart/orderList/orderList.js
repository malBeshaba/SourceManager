// pages/cart/orderList/orderList.js
Page({

  /**
   * Page initial data
   */
  data: {
    user_id: 0,
    source: {
      id:0,
      image:"",
      title:""
    },
    date: [{
      start: "2000-01-01",
      end: "2000-03-12"
    },{
      start: "2000-01-01",
      end: "2000-03-12"
    },{
      start: "2000-01-01",
      end: "2000-03-12"
    },{
      start: "2000-01-01",
      end: "2000-03-12"
    }],
    price: 0,
    date_submit: []
  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function(e) {
    this.setData({
      source: {
        id:e.id,
        image:e.image,
        title:e.name
      }
    })
  },
  checkboxChange: function(e) {
    var value = e.detail.value;
    var date=[];
    for(var i = 0; i<value.length;i++) {
      var d = value[i].split('#');
      var date_o = {
        start:d[0],
        end:d[1]
      };
      date.concat(date_o)
    }
    this.setData({
      date_submit: date
    })
  },
  formSubmit: function(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    wx.request({
      url: 'https://localhost:8080/order',
      data: {
        user_id: 0,
        source_id: this.data.source.id,
        date: this.data.date_submit
      },
      method:"POST",
      responseType:JSON,
      success:  (res) => {
        console.log(res.data);
      },
    })
  },
  formReset: function() {
    console.log('form发生了reset事件')
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