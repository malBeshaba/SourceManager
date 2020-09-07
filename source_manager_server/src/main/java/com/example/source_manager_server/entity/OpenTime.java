package com.example.source_manager_server.entity;

import java.util.Date;

public class OpenTime {
    private Date startTime;
    private Date endTime;

    public OpenTime(Date startTime,Date endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    @Override
    public String toString() {
        return "OpenTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
