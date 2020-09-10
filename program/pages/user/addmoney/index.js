const app = getApp()
Page({

  data: {
    money:0
  },
  getMoney: function (e) {
    console.log( 'money 发生改变，携带值为',e.detail.value);
      this.setData({
          money: e.detail.value
      })
      console.log(money);
  },
  sendMoney:function (e) {
    console.log( '完成充值');
    let pages = getCurrentPages();
    //获取所需页面
    let prevPage = pages[pages.length -2];//上一页
    // prevPage.setData({
    //   money:money //你需要传过去的数据
    // });
    wx.navigateBack({//返回
      delta: 1
    })
    // wx.request({
    //   url: app.globalData.baseURL+"/userInfo/money",
    //   method:'POST',
    //   data:{
    //     money:money
    //   },
    //   success:  (res) => {
    //     console.log("success");
    //   },
    //   fail(err) {
    //     console.log(err)
    //   }
    // }),
  }
})
