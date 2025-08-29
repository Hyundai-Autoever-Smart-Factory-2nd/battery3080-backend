package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ModelInfo {
    private Long modelInfosId;
    private Long modelId;
    private String modelNum;
    private LocalDateTime installedAt;
    private String factoryId;

    // 관계 (N:1)
    private Model model;

    public void setModel(Model model) { this.model = model; }
}


