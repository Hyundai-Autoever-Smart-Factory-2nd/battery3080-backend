package com.example.demo.dto;

public class ModelDetailResponse {
    private Long modelId;
    private Long equipmentId;
    private Double weight;
    private Double speed;
    private String image;
    private Double width;
    private Double length;
    private Double height;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public ModelDetailResponse(Long modelId, Long equipmentId, Double weight, Double speed,
                               String image, Double width, Double length, Double height) {
        this.modelId = modelId;
        this.equipmentId = equipmentId;
        this.weight = weight;
        this.speed = speed;
        this.image = image;
        this.width = width;
        this.length = length;
        this.height = height;
    }


}
