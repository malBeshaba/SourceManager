package com.example.source_manager_server.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Source {
    @Id @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private int type1;
    @Column
    private int type2;
    @Column
    private String describe;
    @Column
    private String[] comment;
    @Column
    private String publisher;
    @Column
    private OpenTime[] openTimes;
    @Column
    private Double unitPrice;
    @Column
    private int concurrentUsage;
    @Column
    private int historicalUsage;
    @Column
    private boolean is_available;
    private @Id @GeneratedValue Integer orderId;


}
