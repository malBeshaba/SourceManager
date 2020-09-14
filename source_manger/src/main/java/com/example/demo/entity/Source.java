package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "source")
public class Source {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type1")
    private int type1;

    @Column(name = "type2")
    private int type2;

    @Column(name = "describe")
    private String describe;

    @Column(name = "comments")
    private String comments;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "starttime")
    private Date startTimes;

    @Column(name = "endtime")
    private Date endTime;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "concurrentusage")
    private int concurrentUsage;

    @Column(name = "historicalusage")
    private int historicalUsage;

    @Column(name = "isavaliable")
    private boolean is_available;

    @Column(name = "orderid")
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(Date startTimes) {
        this.startTimes = startTimes;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getConcurrentUsage() {
        return concurrentUsage;
    }

    public void setConcurrentUsage(int concurrentUsage) {
        this.concurrentUsage = concurrentUsage;
    }

    public int getHistoricalUsage() {
        return historicalUsage;
    }

    public void setHistoricalUsage(int historicalUsage) {
        this.historicalUsage = historicalUsage;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
