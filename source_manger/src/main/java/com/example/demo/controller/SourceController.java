package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.JsonResult;
import com.example.demo.entity.Source;
import com.example.demo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("source")
public class SourceController {
    @Autowired
    private SourceService sourceService;

    /**
     * 查询某用户所有资源
     */
    @GetMapping("all")
    @ResponseBody
    public JSONObject findByPublisher(@RequestParam("username")String publisher){
        return sourceService.findByPublisher(publisher);
    }

    /**
     * 按类别查询资源
     */
    @GetMapping("type")
    @ResponseBody
    public JSONObject findByType(@RequestParam("type1")int type1,@RequestParam("type2")int type2){
        return sourceService.findByType1AndType2(type1,type2);
    }

    /**
     * 按名字查询资源
     */
    @GetMapping("name")
    @ResponseBody
    public JSONObject findByName(@RequestParam("name")String name){
        return sourceService.findByName(name);
    }

    @GetMapping("getById")
    @ResponseBody
    public JSONObject findById(@RequestParam("id") int id) {return  sourceService.findById(id);}

    /**
     * 首页 显示历史使用次数前十的资源
     */
    @GetMapping("homepage")
    @ResponseBody
    public JSONObject findHomepage(){
        return sourceService.findHomepage();
    }

    /**
     * 发布新资源 返回状态码0 提示信息”Add successfully“
     */
    @RequestMapping("add")
    @ResponseBody
    public JSONObject addSource(@RequestParam("name")String name,@RequestParam("type1")int type1,@RequestParam("type2")int type2,@RequestParam("publisher")String publisher,
                                @RequestParam("start_time")String start_time,@RequestParam("end_time")String end_time,@RequestParam("unit_price")double unit_price,
                                @RequestParam("comments")String comments,@RequestParam("describe")String describe,@RequestParam("concurrent_usage")int concurrent_usage,
                                @RequestParam("historical_usage")int historical_usage,@RequestParam("is_available")int is_available){
        return sourceService.addSource(name,type1,type2,publisher,start_time,end_time,unit_price,comments,describe,concurrent_usage,historical_usage,is_available);
    }

    @GetMapping("getByPublisher")
    @ResponseBody
    public JSONObject getByPublisher(@RequestParam("publisher") String name) {
        return sourceService.findByPublisher(name);
    }

//    目前按类传有点问题 写不进数据库。
//
//    我想了两种 一种是像登录那样 先传个资源名字新建一个资源 再把详细信息update进去。
//
//    另一种不传整个对象 每个字段都分开就像/source/add?name=XXX&type1=XXX&type2=XXX&。。。这种的 但是这url也太蠢了吧。。。

}
