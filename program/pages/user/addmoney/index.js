const app = getApp()
Page({

  data: {
    username: '',
    money:0
  },
  onLoad: function(e) {
    this.setData({
      username: e.name
    })
  },
  getMoney: function (e) {
    console.log( 'money 发生改变，携带值为',e.detail.value);
      this.setData({
          money: e.detail.value
      })
      console.log(this.data.money);
  },
  sendMoney:function (e) {
    console.log( '完成充值');
    wx.request({
      url: app.globalData.baseURL+'/user/money?username='+this.data.username+'&num='+this.data.money,
     
      method:"POST",
      success: res => {
        let pages = getCurrentPages();
    //获取所需页面
        let prevPage = pages[pages.length -2];//上一页
       prevPage.setData({
          money:this.data.money //你需要传过去的数据
       });
      wx.navigateBack({//返回
        delta: 1
       })
      }
    })
    
    // wx.request({
    //   url: app.globalData.baseURL+"/userInfo/money",
    //   method:'POST',
    //   data:{
    //     money:this.data.money
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
