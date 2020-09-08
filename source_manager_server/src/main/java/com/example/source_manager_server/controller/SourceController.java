package com.example.source_manager_server.controller;

import com.example.source_manager_server.JsonResult;
import com.example.source_manager_server.entity.Source;
import com.example.source_manager_server.repository.SourceRepository;
import com.example.source_manager_server.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping(value = "/source")
public class SourceController {
    @Autowired
    private SourceService service;

//    public SourceController(SourceRepository repository) {
//        this.repository = repository;
//    }

    /**
     * 按类别查询资源
     */
    JsonResult<List<Source>> findByType(
            @RequestParam("type1") int type1,
            @RequestParam("type2") int type2
    ){
        return new JsonResult<List<Source>>(service.findByType1AndType2(type1,type2));
    }

    /**
     * 按名字查询资源
     */
    JsonResult<List<Source>> findByName(@RequestParam("name")String name){
        return new JsonResult<List<Source>>(service.findByName(name));
    }

    /**
     * 首页 显示历史使用次数前十的资源
     */
    JsonResult<List<Source>> findHomepage(){
        return new JsonResult<List<Source>>(service.findHomepage());
    }

    /**
     * 发布新资源 返回状态码0 提示信息”Add successfully“
     */
    JsonResult addSource(@RequestBody Source source){
        service.addSource(source);
        return new JsonResult("Add successfully");
    }

}
