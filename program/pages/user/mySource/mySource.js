const app = getApp()
const sourceList = "/source/getByPublisher"
Page({
  data: {
    publisher: '',
    list: [1,2,3,4,5,1,1,1,1,1,1,1,1,1]
  },
  onLoad: function(e) {
    // 获取上一个页面传值 source_type1(id) 、 source_type2(index)
    var publisher = e.user;

    // 获取资源类型列表
    const url = app.globalData.baseURL + sourceList;
    wx.request({
      url: url,
      data: {
        publisher: publisher
      },
      success: (res) => {
        console.log(res.data);
        // 赋值
        this.setData({
          list: res.data.data
        })
      }
    })
  }
})