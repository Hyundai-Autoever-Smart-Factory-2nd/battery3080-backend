package com.example.demo.dto;

import java.util.List;

public class EquipmentStatusGroupedResponse {
    private List<EquipmentStatusResponse> goodList;    // ✅ 아이템 단위 DTO (이미 존재하는 EquipmentStatusResponse)
    private List<EquipmentStatusResponse> warningList;
    private List<EquipmentStatusResponse> dangerList;

    public EquipmentStatusGroupedResponse(List<EquipmentStatusResponse> goodList,
                                          List<EquipmentStatusResponse> warningList,
                                          List<EquipmentStatusResponse> dangerList) {
        this.goodList = goodList;
        this.warningList = warningList;
        this.dangerList = dangerList;
    }

    public List<EquipmentStatusResponse> getGoodList() { return goodList; }
    public List<EquipmentStatusResponse> getWarningList() { return warningList; }
    public List<EquipmentStatusResponse> getDangerList() { return dangerList; }
}
