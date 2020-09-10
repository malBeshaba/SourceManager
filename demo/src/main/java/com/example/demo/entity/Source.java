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


}
