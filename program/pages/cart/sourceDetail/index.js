Page({
  data: {
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