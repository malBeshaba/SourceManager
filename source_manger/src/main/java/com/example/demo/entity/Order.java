package com.example.demo.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "subscriber_id")
    private Integer subscriber_id;

    @Column(name = "source_id")
    private Integer source_id;

    @Column(name = "statement")
    private int statement;

    @Column(name = "sum_price")
    private double sum_price;

    @Column(name = "start_time")
    private Date start_time;

    @Column(name = "end_time")
    private Date end_time;
}
