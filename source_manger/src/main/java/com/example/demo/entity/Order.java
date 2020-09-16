package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "subscriber_id")
    private Integer subscriber_id;

    @Column(name = "source_id")
    private Integer source_id;

    @Column(name = "statement")
    private double statement;

    @Column(name = "sum_price")
    private double sum_price;

    public boolean getIs_agreed() {
        return is_agreed;
    }

    public void setIs_agreed(boolean is_agreed) {
        this.is_agreed = is_agreed;
    }

    @Column(name = "is_agreed")
    private boolean is_agreed;

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

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(Integer subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public Integer getSource_id() {
        return source_id;
    }

    public void setSource_id(Integer source_id) {
        this.source_id = source_id;
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

}
