package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Source;
import com.example.demo.entity.User;
import com.example.demo.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    private JSONObject getJsonResult(Iterable iterable,String msg){
        List<Source> sourceList=new ArrayList<>();
        for (Object source:iterable) {
            sourceList.add((Source) source);
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg",msg);
        jsonObject.put("data",sourceList);
        return jsonObject;
    }

//    public JSONObject findAll() {
//        return getJsonResult(sourceRepository.findAll(),"success");
//    }

    public JSONObject findByType1AndType2(int type1, int type2){
        return getJsonResult(sourceRepository.findByType1AndType2(type1,type2),"success");
    }

    public JSONObject findByName(String name) {
        return getJsonResult(sourceRepository.findByName(name),"success");
    }

    public JSONObject findHomepage() {
        return getJsonResult(sourceRepository.findHomepage(),"success");
    }

    public JSONObject findByPublisher(String publisher) {
        return getJsonResult(sourceRepository.findByPublisher(publisher),"success");
    }

//    //@Transactional
//    public JSONObject addSource(Source source) {
//        Source source1=new Source();
//        sourceRepository.save(source1);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("code",0);
//        jsonObject.put("msg","add successfully");
//        return jsonObject;
//    }


    public JSONObject addSource(String name, int type1, int type2, String publisher, String start_time, String end_time, double unit_price, String comments, String describe, int concurrent_usage, int historical_usage, boolean is_available) {
        Source source=new Source();
        return null;
    }
}
