package com.example.demo.controller;

import com.example.demo.JsonResult;
import com.example.demo.entity.Source;
import com.example.demo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/source")
public class SourceController {
    @Autowired
    private SourceService sourceService;

    /**
     * 按类别查询资源
     */
    JsonResult<List<Source>> findByType(@RequestParam("type1")int type1,@RequestParam("Type2")int type2){
        return new JsonResult<List<Source>>(sourceService.findByType1AndType2(type1,type2));
    }

    /**
     * 按名字查询资源
     */
    JsonResult<List<Source>> findByName(@RequestParam("name")String name){
        return new JsonResult<List<Source>>(sourceService.findByName(name));
    }

    /**
     * 首页 显示历史使用次数前十的资源
     */
    JsonResult<List<Source>> findHomepage(){
        return new JsonResult<List<Source>>(sourceService.findHomepage());
    }

    /**
     * 发布新资源 返回状态码0 提示信息”Add successfully“
     */
    JsonResult addSource(@RequestBody Source source){
        sourceService.addSource(source);
        return new JsonResult("Add successfully");
    }


}
