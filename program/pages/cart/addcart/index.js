Page({
  data: {
      showTopTips: false,

      radioItems: [
          {name: '', value: '0'},
          {name: 'cell standard', value: '1', checked: true}
      ],

      date_star: "",
      date_end: "",

      MoneyCodes: ["每天", "每小时", "每月"],
      MoneyCodeIndex: 0,

      types: ["场地租借", "物品租借", "人力租借"],
      typesIndex: 0,
      typesIndex2: 0,

      ground: ["羽毛球", "篮球", "排球","乒乓球", "会议室"],

      goods:["学习用品","生活用品","交通出行"],

      mans:["跑腿","辅导"],
     

 
      isAgree: false,

      src:""
  },
  showTopTips: function(){
      var that = this;
      this.setData({
          showTopTips: true
      });
      setTimeout(function(){
          that.setData({
              showTopTips: false
          });
      }, 3000);
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
      typesIndex: e.detail.value
    })
},
  bindAgreeChange: function (e) {
      this.setData({
          isAgree: !!e.detail.value.length
      });
  },
  onShareAppMessage() {
    return {
      title: '上传文件',
      path: '/pages/cart/addcart'
    }
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