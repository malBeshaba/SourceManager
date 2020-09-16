const app = getApp();
Page({
  data: {
      source_id: null,
      name:null,
      price:null,
      describe:null,
      date_start: "",
      time_start: "",
      date_end: "",
      time_end: "",
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
    console.log(this.data);
    var data = this.data;
      wx.request({
        url: 'http://localhost:8080/source/add?name='+data.name+'&type1='+data.typesIndex+'&type2='+data.typesIndex2+'&publisher='+app.globalData.userInfo.nickName+'&start_time='+data.date_start+data.time_start+'&end_time='+data.date_end+data.time_end+'&unit_price='+data.price+'&comments=1&describe=11&concurrent_usage=1&historical_usage=1&is_available=1',
        method:'POST',
        success:  (res) => {
          console.log(res.data);
          // 赋值
          
          this.upload(res.data.data);
        },
        fail(err) {
          console.log(err)
        }
      })
   
  },
  bindName: function (e) {
    this.setData({
      name: e.detail.value
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
  bindDateChange1: function (e) {
      this.setData({
          date_start: e.detail.value
      })
  },
  bindDateChange2: function (e) {
      this.setData({
          date_end: e.detail.value
      })
  },
  bindTimeChange1: function (e) {
    this.setData({
        time_start: e.detail.value
    })
},
bindTimeChange2: function (e) {
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
  upload:function (id) {
    wx.uploadFile({
     url: app.globalData.baseURL+'/sourceimage/upload',
     filePath: this.data.src,
     name: 'file',
    //  formData: {
    //    source_id: this.data.source_id
    //  },
    header:{
      source_id: id
    },
     success: function (res) {
     console.log(res.data);
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
         this.setData({
           src: res.tempFilePaths[0]
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