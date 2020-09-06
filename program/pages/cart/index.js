Page({
  data: {
    cateItems: [
      {
        cate_id: 1,
        cate_name: "场地租借",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '羽毛球',
            image: "/images/badminton.jpg"
          },
          {
            child_id: 2,
            name: '篮球',
            image: "/images/basketball.jpg"
          },
          {
            child_id: 3,
            name: '排球',
            image:  "/images/volleyball.jpg"
          },
          {
            child_id: 4,
            name: '乒乓球',
            image: "/images/Tabletennis.jpg"
          },
          {
            child_id: 5,
            name: '会议室',
            image: "/images/meeting.jpg"
          }
        ]
      },
      {
        cate_id: 2,
        cate_name: "物品租借",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '学习用品',
            image: "/images/study.jpg"
          },
          {
            child_id: 2,
            name: '生活用品',
            image: "/images/life.jpg"
          },
          {
            child_id: 2,
            name: '交通出行',
            image: "/images/transport.jpg"
          }
        ]
      },
      {
        cate_id: 3,
        cate_name: "人力租借",
        ishaveChild: true,
        children:
        [
          {
            child_id: 1,
            name: '跑腿',
            image: "/images/run.jpg"
          },
          {
            child_id: 2,
            name: '辅导',
            image: "/images/help.jpg"
          },
        ]
      },
    ],
    curNav: 1,
    curIndex: 0
  },

  //事件处理函数  
  switchRightTab: function (e) {
    // 获取item项的id，和数组的下标值  
    let id = e.target.dataset.id,
      index = parseInt(e.target.dataset.index);
    // 把点击到的某一项，设为当前index  
    this.setData({
      curNav: id,
      curIndex: index
    })
  }
}) 