const app = getApp()
const sourceList = "/source"
Page({
  data: {
    source_type1: -1,
    source_type2: -1,
    list: null
  },
  onLoad: function(e) {
    // 获取上一个页面传值 source_type1(id) 、 source_type2(index)
    var id = e.id;
    var index = e.index;
    this.setData({
      source_type1: id,
      source_type2: index
    })

    // 获取资源类型列表
    const url = app.globalData.baseURL + sourceList;
    wx.request({
      url: url,
      data: {
        source_type1: source_type1,
        source_type2: source_type2
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