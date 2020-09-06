const order = ['demo1', 'demo2', 'demo3']

Page({
  data: {
    list: [], // 数据列表
    imgUrls: null,
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    col1: [],
    col2: []
  },

  onPulling(e) {
    console.log('onPulling:', e)
  },
  onRefresh() {
    if (this._freshing) return
    this._freshing = true
    setTimeout(() => {
      this.setData({
        triggered: false,
      })
      this._freshing = false
    }, 3000)
  },
  onRestore(e) {
    console.log('onRestore:', e)
  },
  onAbort(e) {
    console.log('onAbort', e)
  },

  upper(e) {
    console.log(e)
  },

  lower(e) {
    console.log(e)
  },

  scroll(e) {
    console.log(e)
  },

  scrollToTop() {
    this.setAction({
      scrollTop: 0
    })
  },
  onLoad: function (options) { 
   const url="https://api.tianapi.com/dongman/index"; 
    wx.request({
      url: url,
      data:{
        key: '9843e93b87f121e83c9971f037c05135',
        num: 10
      },
      success:  (res) => {
        console.log(res.data);
        // 赋值
        this.setData({
          list: res.data.newslist
        })
      }
    })
  
}
  
})
