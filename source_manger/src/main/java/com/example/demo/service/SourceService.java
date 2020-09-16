package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Source;
import com.example.demo.entity.SourceDetail;
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
        List<SourceDetail> sourceList=new ArrayList<>();
        for (Object source:iterable) {
            sourceList.add((SourceDetail) source);
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
        List<SourceDetail> list = new ArrayList<>();
        for (Source source: sourceRepository.findByType1AndType2(type1,type2)) {
            list.add(new SourceDetail(source, "http://localhost:8080/sourceimage/get?source_id="+source.getId()));
        }
        return getJsonResult(list,"success");
    }

    public JSONObject findByName(String name) {
        List<SourceDetail> list = new ArrayList<>();
        for (Source source: sourceRepository.findByName(name)) {
            list.add(new SourceDetail(source, "http://localhost:8080/sourceimage/get?source_id="+source.getId()));
        }
        return getJsonResult(list,"success");
    }

    public JSONObject findById(int id) {

        List<SourceDetail> list = new ArrayList<>();
        for (Source source: sourceRepository.findById(id)) {
            list.add(new SourceDetail(source, "http://localhost:8080/sourceimage/get?source_id="+source.getId()));
        }
        return getJsonResult(list,"success");
    }

    public JSONObject findHomepage() {
        List<SourceDetail> list = new ArrayList<>();
        for (Source source: sourceRepository.findHomepage()) {
            list.add(new SourceDetail(source, "http://localhost:8080/sourceimage/get?source_id="+source.getId()));
        }
        return getJsonResult(list,"success");
    }

    public JSONObject findByPublisher(String publisher) {
        List<SourceDetail> list = new ArrayList<>();
        for (Source source: sourceRepository.findByPublisher(publisher)) {
            list.add(new SourceDetail(source, "http://localhost:8080/sourceimage/get?source_id="+source.getId()));
        }
        return getJsonResult(list,"success");
    }

    public JSONObject addSource(String name, int type1, int type2, String publisher, String start_time, String end_time, double unit_price, String comments, String describe, int concurrent_usage, int historical_usage, int is_available) {
        sourceRepository.insertSource(name,type1,type2,publisher,start_time,end_time,unit_price,comments,describe,concurrent_usage,historical_usage, is_available);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","add successfully");
        return jsonObject;
    }
}
