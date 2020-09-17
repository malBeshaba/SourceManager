package com.example.demo.entity;

import javax.persistence.Column;

public class OrderDetail {
    private Integer id;

    private Integer subscriber_id;

    private String subsecriber;

    private double statement;

    private double sum_price;

    private boolean is_agreed;



    private int source_id;

    private String source_img;

    private String sourceName;

    private String owner;

    private String start_time;

    private String end_time;

    public OrderDetail(Order order, SourceDetail source) {
        this.setId(order.getId());
        this.setIs_agreed(order.getIs_agreed());
        this.setOwner(order.getOwner());
        this.setSource_id(order.getSource_id());
        this.setSource_img(source.getImgUrl());
        this.setSourceName(source.getName());
        this.setStatement(order.getStatement());
        this.setSubscriber_id(order.getSubscriber_id());
        this.setSum_price(order.getSum_price());
        this.setStart_time(order.getStart_time());
        this.setEnd_time(order.getEnd_time());
    }

    public String getSubsecriber() {
        return subsecriber;
    }

    public void setSubsecriber(String subsecriber) {
        this.subsecriber = subsecriber;
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

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(Integer subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public double getStatement() {
        return statement;
    }

    public void setStatement(double statement) {
        this.statement = statement;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }

    public boolean isIs_agreed() {
        return is_agreed;
    }

    public void setIs_agreed(boolean is_agreed) {
        this.is_agreed = is_agreed;
    }

    public String getSource_img() {
        return source_img;
    }

    public void setSource_img(String source_img) {
        this.source_img = source_img;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
