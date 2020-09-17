Page({
  data: {
    id: 0,
    imageUrl: '/images/utry.jpg',
    name: 'null',
    type: 'null',
    describe: 'null',
    price: 'null',
    total_use_num: '121',
    command: [
      {
      user_name: 'h',
      content: '222'
      },
      {
      user_name: 'h',
      content: 'command_listcommand_listcommand_listcommand_listcommand_listcommand_listcommand_listcommand_listcommand_listcommand_listcommand_list'
      }
    ]
  },
  set_order: function(e) {
    var that=this;
    wx.navigateTo({
      url: '/pages/cart/orderList/orderList?id='+that.data.id+'&name='+that.data.name+'&price='+that.data.price,
    })
    console.log('source', this.data.imageUrl)
  },
  onLoad: function(e) {
    var id = e.id
    this.setData({
      id: id
    })
    wx.request({
      url: 'http://localhost:8080/source/getById',
      data: {
        id: id
      },
      success:  (res) => {
        console.log(res.data);
        // 赋值
        var data = res.data.data[0]
        this.setData({
          imageUrl: data.imgUrl,
          name: data.name,
          type: data.type,
          describe: data.describe,
          price: data.unit_price,
          command: data.commants
        })
      },
    })
  }
}) 