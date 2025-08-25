package com.example.demo.model;

public class Home {
    private double avgBattery;   // AGV 평균 배터리
    private int alertCount;      // 배터리 경고 수
    private String equipmentName; // 장비 이름

    // 기본 생성자
    public Home() {}

    // 전체 생성자
    public Home(double avgBattery, int alertCount, String equipmentName) {
        this.avgBattery = avgBattery;
        this.alertCount = alertCount;
        this.equipmentName = equipmentName;
    }

    // Getter/Setter
    public double getAvgBattery() {
        return avgBattery;
    }

    public void setAvgBattery(double avgBattery) {
        this.avgBattery = avgBattery;
    }

    public int getAlertCount() {
        return alertCount;
    }

    public void setAlertCount(int alertCount) {
        this.alertCount = alertCount;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}