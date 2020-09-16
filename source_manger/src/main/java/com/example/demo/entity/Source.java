package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "source")
public class Source {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type1")
    private int type1;

    @Column(name = "type2")
    private int type2;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "unit_price")
    private double unit_price;

    @Column(name = "comments")
    private String comments;

    @Column(name = "describe")
    private String describe;

    @Column(name = "concurrent_usage")
    private int concurrent_usage;

    @Column(name = "historical_usage")
    private int historical_usage;

    @Column(name = "is_available")
    private int is_available;

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

    public int isIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }
}
