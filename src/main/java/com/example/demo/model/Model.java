package com.example.demo.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Model {
    private Long modelId;
    private Long equipmentId;
    private Double weight;
    private Double speed;
    private String image;
    private Double width;
    private Double length;
    private Double height;

    private Equipment equipment;           // 하나의 Model은 한 Equipment에 속함
    private List<ModelInfo> modelInfos;    // 하나의 Model은 여러 ModelInfo 가짐
}
