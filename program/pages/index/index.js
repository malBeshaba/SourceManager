const app = getApp();

Page({
  data: {
    list: [], // 数据列表
    imgUrls: null,
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    name:""
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
      if(e.scrollTop<0){
          wx.pageScrollTo({
          scrollTop: 0
         })
      }
  },

  scroll(e) {
    console.log(e)
  },

  scrollToTop() {
    this.setAction({
      scrollTop: 0
    })
  },
  Tofind(){
    
    console.log("开始搜索")
  },
  onLoad: function (options) { 
    wx.request({
      url: app.globalData.baseURL+"/source/homepage",
      // responseType:JSON,
      success:  (res) => {
        console.log(res.data);
        // 赋值
        this.setData({
          list: res.data.data
        })
      },
      fail(err) {
        console.log(err)
      }
    })
  
}
  
})
