package com.example.demo.entity;

import javax.persistence.Column;

public class SourceDetail {
    private int id;

    private String name;

    private int type1;

    private int type2;

    private String publisher;

    private String start_time;

    private String end_time;

    private double unit_price;

    private String comments;

    private String describe;

    private int concurrent_usage;

    private int historical_usage;

    private int is_available;

    private String imgUrl;

    public SourceDetail() {

    }

    public SourceDetail(Source source, String imgUrl) {
        this.setId(source.getId());
        this.setName(source.getName());
        this.setComments(source.getName());
        this.setConcurrent_usage(source.getConcurrent_usage());
        this.setDescribe(source.getDescribe());
        this.setEnd_time(source.getEnd_time());
        this.setHistorical_usage(source.getHistorical_usage());
        this.setIs_available(source.isIs_available());
        this.setPublisher(source.getPublisher());
        this.setStart_time(source.getStart_time());
        this.setType1(source.getType1());
        this.setType2(source.getType2());
        this.setUnit_price(source.getUnit_price());
        this.setImgUrl(imgUrl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType1() {
        return type1;
    }

    public void setType1(int type1) {
        this.type1 = type1;
    }

    public int getType2() {
        return type2;
    }

    public void setType2(int type2) {
        this.type2 = type2;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getConcurrent_usage() {
        return concurrent_usage;
    }

    public void setConcurrent_usage(int concurrent_usage) {
        this.concurrent_usage = concurrent_usage;
    }

    public int getHistorical_usage() {
        return historical_usage;
    }

    public void setHistorical_usage(int historical_usage) {
        this.historical_usage = historical_usage;
    }

    public int getIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
