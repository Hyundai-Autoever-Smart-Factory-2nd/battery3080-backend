package com.example.demo.model;

import java.time.LocalDateTime;

public class EquipmentModelDTO {
    private Long modelId;
    private String modelNum;
    private String factoryId;
    private Double weight;
    private Double speed;
    private String equipmentName;
    private LocalDateTime installedAt;

    // Getter / Setter
    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }

    public String getModelNum() { return modelNum; }
    public void setModelNum(String modelNum) { this.modelNum = modelNum; }

    public String getFactoryId() { return factoryId; }
    public void setFactoryId(String factoryId) { this.factoryId = factoryId; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getSpeed() { return speed; }
    public void setSpeed(Double speed) { this.speed = speed; }

    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public LocalDateTime getInstalledAt() { return installedAt; }
    public void setInstalledAt(LocalDateTime installedAt) { this.installedAt = installedAt; }
}