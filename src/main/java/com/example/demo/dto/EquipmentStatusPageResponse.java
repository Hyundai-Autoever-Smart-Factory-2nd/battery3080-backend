package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStatusPageResponse {
    private Integer totalCount;                          // 요청한 상태의 전체 개수
    private List<EquipmentStatusResponse> equipmentList; // 장비 리스트 (XML과 매핑되도록 필드명 변경)
}
