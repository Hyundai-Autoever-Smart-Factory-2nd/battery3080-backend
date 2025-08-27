package com.example.demo.model;

import java.util.List;

public class Equipment {
    private Long equipmentId;
    private String name;

    // 관계 (1:N)
    private List<Model> models;

    // getter/setter
    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Model> getModels() { return models; }
    public void setModels(List<Model> models) { this.models = models; }
}


//package com.example.demo.model;
//
//public class Equipment {
//    private Long equipmentId; // equipment_id
//    private String name;      // name
//
//    // getter / setter
//    public Long getEquipmentId() {
//        return equipmentId;
//    }
//    public void setEquipmentId(Long equipmentId) {
//        this.equipmentId = equipmentId;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}
