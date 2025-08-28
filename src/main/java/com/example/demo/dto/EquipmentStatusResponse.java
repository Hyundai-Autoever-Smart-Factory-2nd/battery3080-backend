package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EquipmentStatusResponse {
    private Long equipmentId;
    private Long modelInfosId;
    private String modelNum;
    private double temp;
    private double cRate;
    private String status;// GOOD / WARNING / DANGER

}
