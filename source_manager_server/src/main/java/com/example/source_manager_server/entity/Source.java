package com.example.source_manager_server.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Source {
    private @Id @GeneratedValue Integer id;
    private String name;
    private String type;
    private String describe;
    private String[] comment;
    private String publisher;
    private OpenTime[] openTimes;
    private Double unitPrice;
    private int ConcurrentUsage;
    private int HistoricalUsage;
    private @Id @GeneratedValue Integer orderId;


}
