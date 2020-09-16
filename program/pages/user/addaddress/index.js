var index = 0;
const app = getApp();
Page({
  data:{
    name:"请填写您的姓名",
    tel:"请填写您的联系方式",
    addreValue:0,
    door:"街道门牌信息",
    area:"如安徽省铜陵市",
  },
  formSubmit: function(e) {
    var warn ="";
    var that = this;
    var flag = false;
    if(e.detail.value.name==""){
      warn = "请填写您的姓名！";
    }else if(e.detail.value.tel==""){
      warn = "请填写您的手机号！";
    }else if(!(/^1(3|4|5|7|8)\d{9}$/.test(e.detail.value.tel))){
      warn = "手机号格式不正确";
    }else if(e.detail.value.addre=='0'){
      warn = "请选择您的所在区域";
    }else if(e.detail.value.door==""){
      warn = "请输入您的具体地址";
    }else{
      flag=true;
      console.log('form发生了submit事件，携带数据为：', e.detail.value)
      this.setData({
        name: e.detail.value.name,
        tel: e.detail.value.tel,
        area: e.detail.value.area,
        door: e.detail.value.door 
      })
        // wx.redirectTo({
        // url: '../chooseAddre/chooseAddre?tel='+e.detail.value.tel+"&addre="+that.data.addreRange[e.detail.value.addre]+"&door="+e.detail.value.door+"&name="+e.detail.value.name+"&area="+that.data.areaRange[e.detail.value.area]+"&flag="+flag+"&areavalue="+e.detail.value.area+"&addrevalue="+e.detail.value.addre+"&door="+e.detail.value.door
        // //？后面跟的是需要传递到下一个页面的参数
        // }); 
         console.log("传过去的地址下标是多少？"+e.detail.value.addre)
    }
    if(flag==false){
      wx.showModal({
      title: '提示',
      content:warn
    })
    }
    
  },
  submit: function(e) {
    var that = this.data;
    wx.request({
      url: app.globalData.baseURL + '/user/address?username='+that.name+'&tel='+that.tel+'&area='+that.area+'&address='+that.door,
      method:"POST",
      success: (res) => {
        console.log('success');
        console.log(res)
      },
      fail: (res) => {
        console.log('fail');
      }
    })
  }
  })