package com.example.demo.dto;

import java.util.List;

public class EquipmentStatusPageResponse {
    private int totalCount;  // 요청한 상태의 전체 개수
    private List<EquipmentStatusResponse> data;

    public EquipmentStatusPageResponse(int totalCount, List<EquipmentStatusResponse> data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public int getTotalCount() { return totalCount; }
    public List<EquipmentStatusResponse> getData() { return data; }
}
