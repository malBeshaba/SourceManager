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
      url: '/pages/cart/orderList/orderList?id='+that.data.id+'&image='+that.data.imageUrl+'&name='+that.data.name+'&price='+that.data.price,
    })
  },
  onLoad: function(e) {
    var id = e.id
    
    wx.request({
      url: 'https://localhost:8080/source',
      data: {
        id: id
      },
      responseType:JSON,
      success:  (res) => {
        console.log(res.data);
        // 赋值
        var data = res.data.data
        this.setData({
          imageUrl: data.imageUrl,
          name: data.name,
          type: data.type,
          describe: data.describe,
          price: data.price,
          command: data.command.split('//')
        })
      },
    })
  }
}) 