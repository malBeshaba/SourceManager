const app = getApp()
const sourceList = "/source/type"
Page({
  data: {
    source_type1: -1,
    source_type2: -1,
    list: []
  },
  onLoad: function(e) {
    // 获取上一个页面传值 source_type1(id) 、 source_type2(index)
    if (e.id != null) {
      this.loadByType(e);
    }
    if (e.name != null) {
      this.loadByName(e);
    }
  },
  loadByName: function(e) {
    var name = e.name;
    wx.request({
      url: app.globalData.baseURL + '/source/name',
      data: {
        name: name
      },
      success: res => {
        console.log('search',res.data)
        this.setData({
          list: res.data.data
        })
      }
    })
  },
  loadByType: function(e) {
    var id = parseInt(e.id) + 1;
    var index = e.index;
    console.log(id, index);
    this.setData({
      source_type1: id,
      source_type2: index
    })

    // 获取资源类型列表
    const url = app.globalData.baseURL + sourceList;
    wx.request({
      url: url,
      data: {
        type1: this.data.source_type1,
        type2: this.data.source_type2
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