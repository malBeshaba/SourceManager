const app = getApp();
Page({
  data: {
      name:null,
      price:null,
      describe:null,
      date_start: "",
      time_start: "",
      date_end: "",
      time_end: "",

      MoneyCodes: ["每天", "每小时", "每月"],
      MoneyCodeIndex: 0,
     // 每天-0，每小时-1，每月-2

      types: ["场地租借", "物品租借", "人力租借"],
      typesIndex: 0,
      //类型1
      typesIndex2: 0,
      //类型2

      ground: ["羽毛球", "篮球", "排球","乒乓球", "会议室"],

      goods:["学习用品","生活用品","交通出行"],

      mans:["跑腿","辅导"],
     
      isAgree: false,

      src:""
  },
  showTopTips: function(){
    let pages = getCurrentPages();
    //获取所需页面
    let prevPage = pages[pages.length -2];//上一页
    // prevPage.setData({
    //   money:money //你需要传过去的数据
    // });
    wx.navigateBack({//返回
      delta: 1
    })
      wx.request({
        url: app.globalData.baseURL+"/source",
        method:'POST',
        data:{
          name:this.data.name,
          price:this.data.price,
          describe:this.data.describe,
          date_start:this.data.date_start ,
          time_start: this.data.time_start,
          date_end: this.data.date_end,
          time_end: this.data.time_end,
          MoneyCodeIndex:  this.data.MoneyCodeIndex,
          typesIndex:this.data.typesIndex,
          typesIndex2:this.data.typesIndex2
        },
        success:  (res) => {
          console.log(res.data);
          // 赋值
          this.setData({
            list: res.data.newslist
          })
        },
        fail(err) {
          console.log(err)
        }
      })
    
  },

  bindPrice: function (e) {
    this.setData({
       price: e.detail.value
    }),
    console.log("价格：",this.data.price)
  },
  bindDescribe: function (e) {
    this.setData({
      describe: e.detail.value
    }),
    console.log("描述:",this.data.describe)
  },
  bindDate1Change: function (e) {
      this.setData({
          date_start: e.detail.value
      })
  },
  bindDate2Change: function (e) {
      this.setData({
          date_end: e.detail.value
      })
  },
  bindTime1Change: function (e) {
    this.setData({
        time_start: e.detail.value
    })
},
bindTime2Change: function (e) {
    this.setData({
        time_end: e.detail.value
    })
},
  bindMoneyChange: function(e) {
    console.log('picker  money 发生选择改变，携带值为', e.detail.value);

    this.setData({
     MoneyIndex: e.detail.value
    })
},
  bindtypesChange: function(e) {
      console.log('picker  types 发生选择改变，携带值为', e.detail.value);
      this.setData({
        typesIndex: e.detail.value
      })
  },
  bindtypesChange2: function(e) {
    console.log('picker  types2 发生选择改变，携带值为', e.detail.value);

    this.setData({
      typesIndex2: e.detail.value
    })
},
  // bindAgreeChange: function (e) {
  //     this.setData({
  //         isAgree: !!e.detail.value.length
  //     });
  // },
  onShareAppMessage() {
    return {
      title: '上传文件',
      path: '/pages/cart/addcart'
    }
  },
  upload:function (page, path) {
    wx.uploadFile({
     url: "",
     filePath: path[0],
     name: 'file',
     success: function (res) {
     console.log(res);
     }
    })
  },
 chooseImage() {
      const self = this
      wx.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'],
        sourceType: ['album', 'camera'],
        success: res => {
          // success
          console.log(res)
            this.setData({
              src:res.tempFilePaths
          })
          // upload(that, src);
        },

        fail: res => {
          wx.showToast({
            icon: 'none',
            title: '上传失败',
          })
          console.log('uploadImage fail, errMsg is', res.errMsg)
        }
      })
  }
});