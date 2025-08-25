package com.example.demo.model;

import java.util.List;

public class Model {
    private Long modelId;
    private Long equipmentId;
    private Double weight;
    private Double speed;
    private String image;
    private Double width;
    private Double length;
    private Double height;

    // 관계 (N:1, 1:N)
    private Equipment equipment;           // 하나의 Model은 한 Equipment에 속함
    private List<ModelInfo> modelInfos;    // 하나의 Model은 여러 ModelInfo 가짐

    // getter/setter
    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }

    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getSpeed() { return speed; }
    public void setSpeed(Double speed) { this.speed = speed; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Double getWidth() { return width; }
    public void setWidth(Double width) { this.width = width; }

    public Double getLength() { return length; }
    public void setLength(Double length) { this.length = length; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Equipment getEquipment() { return equipment; }
    public void setEquipment(Equipment equipment) { this.equipment = equipment; }

    public List<ModelInfo> getModelInfos() { return modelInfos; }
    public void setModelInfos(List<ModelInfo> modelInfos) { this.modelInfos = modelInfos; }
}

//package com.example.demo.model;
//
//public class Model {
//    private Long modelId;       // model_id
//    private Long equipmentId;   // equipment_id (FK → equipments.equipment_id)
//    private Double weight;
//    private Double speed;
//    private String image;
//    private Double width;
//    private Double length;
//    private Double height;
//
//    // getter / setter
//    public Long getModelId() {
//        return modelId;
//    }
//    public void setModelId(Long modelId) {
//        this.modelId = modelId;
//    }
//
//    public Long getEquipmentId() {
//        return equipmentId;
//    }
//    public void setEquipmentId(Long equipmentId) {
//        this.equipmentId = equipmentId;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }
//
//    public Double getSpeed() {
//        return speed;
//    }
//    public void setSpeed(Double speed) {
//        this.speed = speed;
//    }
//
//    public String getImage() {
//        return image;
//    }
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Double getWidth() {
//        return width;
//    }
//    public void setWidth(Double width) {
//        this.width = width;
//    }
//
//    public Double getLength() {
//        return length;
//    }
//    public void setLength(Double length) {
//        this.length = length;
//    }
//
//    public Double getHeight() {
//        return height;
//    }
//    public void setHeight(Double height) {
//        this.height = height;
//    }
//}
