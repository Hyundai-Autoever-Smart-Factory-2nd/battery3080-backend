package com.example.demo.dto;

import com.example.demo.model.Equipment;
import java.util.List;

public class EquipmentStatusResponse {
    private List<Equipment> goodList;    // 양호
    private List<Equipment> warningList; // 주의
    private List<Equipment> dangerList;  // 경고

    public EquipmentStatusResponse(List<Equipment> goodList, List<Equipment> warningList, List<Equipment> dangerList) {
        this.goodList = goodList;
        this.warningList = warningList;
        this.dangerList = dangerList;
    }

    // getter/setter
    public List<Equipment> getGoodList() { return goodList; }
    public void setGoodList(List<Equipment> goodList) { this.goodList = goodList; }

    public List<Equipment> getWarningList() { return warningList; }
    public void setWarningList(List<Equipment> warningList) { this.warningList = warningList; }

    public List<Equipment> getDangerList() { return dangerList; }
    public void setDangerList(List<Equipment> dangerList) { this.dangerList = dangerList; }
}
