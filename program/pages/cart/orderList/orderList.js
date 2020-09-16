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
    price: 30,
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
      },
      price: e.price
    })
  },
  checkboxChange: function(e) {
    var value = e.detail.value;
    console.log('evalue',e.detail.value);
    var date=[];
    for(var i = 0; i<value.length;i++) {
      var d = value[i].split('#');
      console.log('d', d);
      var date_o = {
        start:d[0],
        end:d[1]
      };
      console.log('date_o',date_o);
      date.push(date_o);
    }
    this.setData({
      date_submit: date
    })
  },
  formSubmit: function(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
    var that = this;
    var price = that.data.date_submit.length * that.data.price;
    wx.showModal({
      title: '提交订单',
      content: '本次订单总金额为：'+price+'元',
      success: function (res) {
          if (res.confirm) {
              console.log('用户点击确定')
              wx.navigateBack({ changed: true });
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
          }else{
             console.log('用户点击取消')
          }

      }
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