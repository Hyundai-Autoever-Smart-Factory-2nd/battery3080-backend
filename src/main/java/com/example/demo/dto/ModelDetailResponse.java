package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModelDetailResponse {
    private Long modelId;
    private Long equipmentId;
    private Double weight;
    private Double speed;
    private String image;
    private Double width;
    private Double length;
    private Double height;
}
