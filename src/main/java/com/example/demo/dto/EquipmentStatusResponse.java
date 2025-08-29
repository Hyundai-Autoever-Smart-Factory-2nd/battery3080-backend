package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStatusResponse {
    private Long equipmentId;     // equipments.equipment_id (BIGINT)
    private Long modelInfosId;    // model_infos.model_infos_id (BIGINT)
    private String modelNum;      // model_infos.model_num (VARCHAR)
    private Double temp;          // data_logs.temp (DOUBLE) - null 가능성 고려
    private Double cRate;         // data_logs.c-rate (DOUBLE) - null 가능성 고려
    private String status;        // 계산된 상태 ('good' / 'warning' / 'danger')
}
