package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class EquipmentModelDTO {
    private Long modelId;
    private String modelNum;
    private String factoryId;
    private Double weight;
    private Double speed;
    private String equipmentName;
    private LocalDateTime installedAt;
}
