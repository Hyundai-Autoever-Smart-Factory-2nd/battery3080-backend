package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EquipmentDetailResponse {
    private Long modelInfosId;
    private String modelNum;
    private String status;     // GOOD / WARNING / DANGER
    private int battery;       // 배터리 잔량(%)
    private LocalDateTime lastUpdated;
    private List<String> logs; // 로그 리스트

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public Long getModelInfosId() {
        return modelInfosId;
    }

    public void setModelInfosId(Long modelInfosId) {
        this.modelInfosId = modelInfosId;
    }

    public EquipmentDetailResponse(Long modelInfosId, String modelNum, String status,
                                   int battery, LocalDateTime lastUpdated, List<String> logs) {
        this.modelInfosId = modelInfosId;
        this.modelNum = modelNum;
        this.status = status;
        this.battery = battery;
        this.lastUpdated = lastUpdated;
        this.logs = logs;
    }

    // getter/setter
}
