package com.example.demo.dto;

public class EquipmentStatusResponse {
    private Long equipmentId;
    private String name;
    private String modelNum;
    private int temp;       // 임의 temp 값
    private String status;  // GOOD / WARNING / DANGER

    private EquipmentStatusResponse() {}

    public EquipmentStatusResponse(Long equipmentId, String name, String modelNum, int temp, String status) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.modelNum = modelNum;
        this.temp = temp;
        this.status = status;
    }

    // Getter/Setter
    public Long getEquipmentId() { return equipmentId; }
    public void setEquipmentId(Long equipmentId) { this.equipmentId = equipmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getModelNum() { return modelNum; }
    public void setModelNum(String modelNum) { this.modelNum = modelNum; }

    public int getTemp() { return temp; }
    public void setTemp(int temp) { this.temp = temp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}



//package com.example.demo.dto;
//
//import com.example.demo.model.Equipment;
//import java.util.List;
//
//public class EquipmentStatusResponse {
//    private List<Equipment> goodList;    // 양호
//    private List<Equipment> warningList; // 주의
//    private List<Equipment> dangerList;  // 경고
//
//    public EquipmentStatusResponse(List<Equipment> goodList, List<Equipment> warningList, List<Equipment> dangerList) {
//        this.goodList = goodList;
//        this.warningList = warningList;
//        this.dangerList = dangerList;
//    }
//
//    // getter/setter
//    public List<Equipment> getGoodList() { return goodList; }
//    public void setGoodList(List<Equipment> goodList) { this.goodList = goodList; }
//
//    public List<Equipment> getWarningList() { return warningList; }
//    public void setWarningList(List<Equipment> warningList) { this.warningList = warningList; }
//
//    public List<Equipment> getDangerList() { return dangerList; }
//    public void setDangerList(List<Equipment> dangerList) { this.dangerList = dangerList; }
//}
