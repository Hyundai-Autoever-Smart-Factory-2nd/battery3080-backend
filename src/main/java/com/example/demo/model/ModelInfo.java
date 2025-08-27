package com.example.demo.model;

import java.time.LocalDateTime;

public class ModelInfo {
    private Long modelInfosId;
    private Long modelId;
    private String modelNum;
    private LocalDateTime installedAt;
    private String factoryId;

    // 관계 (N:1)
    private Model model;

    // getter/setter
    public Long getModelInfosId() { return modelInfosId; }
    public void setModelInfosId(Long modelInfosId) { this.modelInfosId = modelInfosId; }

    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }

    public String getModelNum() { return modelNum; }
    public void setModelNum(String modelNum) { this.modelNum = modelNum; }

    public LocalDateTime getInstalledAt() { return installedAt; }
    public void setInstalledAt(LocalDateTime installedAt) { this.installedAt = installedAt; }

    public String getFactoryId() { return factoryId; }
    public void setFactoryId(String factoryId) { this.factoryId = factoryId; }

    public Model getModel() { return model; }
    public void setModel(Model model) { this.model = model; }
}

//package com.example.demo.model;
//
//import java.time.LocalDateTime;
//
//public class ModelInfo {
//    private Long modelInfosId;  // model_infos_id
//    private Long modelId;       // model_id (FK → models.model_id)
//    private String modelNum;    // model_num
//    private LocalDateTime installedAt; // installed_at
//    private String factoryId;   // factory_id
//
//    // getter / setter
//    public Long getModelInfosId() {
//        return modelInfosId;
//    }
//    public void setModelInfosId(Long modelInfosId) {
//        this.modelInfosId = modelInfosId;
//    }
//
//    public Long getModelId() {
//        return modelId;
//    }
//    public void setModelId(Long modelId) {
//        this.modelId = modelId;
//    }
//
//    public String getModelNum() {
//        return modelNum;
//    }
//    public void setModelNum(String modelNum) {
//        this.modelNum = modelNum;
//    }
//
//    public LocalDateTime getInstalledAt() {
//        return installedAt;
//    }
//    public void setInstalledAt(LocalDateTime installedAt) {
//        this.installedAt = installedAt;
//    }
//
//    public String getFactoryId() {
//        return factoryId;
//    }
//    public void setFactoryId(String factoryId) {
//        this.factoryId = factoryId;
//    }
//}
