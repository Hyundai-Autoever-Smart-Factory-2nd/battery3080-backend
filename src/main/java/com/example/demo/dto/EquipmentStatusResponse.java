package com.example.demo.dto;

public class EquipmentStatusResponse {
    private Long equipmentId;
    private Long modelInfosId; // 추가
    private String modelNum;
    private double temp;
    private double cRate ;
    private String status;// GOOD / WARNING / DANGER

    private EquipmentStatusResponse() {}

    public EquipmentStatusResponse(Long equipmentId, Long modelInfosId, String modelNum, double temp,double cRate, String status) {
        this.equipmentId = equipmentId;
        this.modelInfosId = modelInfosId;
        this.modelNum = modelNum;
        this.temp = temp;
        this.cRate  = cRate;
        this.status = status;
    }

    public double getCRate() { return cRate; }
    public void setCRate(double cRate) { this.cRate = cRate; }

    public double getTemp() { return temp; }
    public void setTemp(double temp) { this.temp = temp; }

    public Long getModelInfosId() {
        return modelInfosId;
    }

    public void setModelInfosId(Long modelInfosId) {
        this.modelInfosId = modelInfosId;
    }

    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public String getModelNum() { return modelNum; }
    public void setModelNum(String modelNum) { this.modelNum = modelNum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
