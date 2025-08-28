package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EquipmentDetailResponse {

    // 장비 기본 정보
    private Long modelInfosId;
    private String modelNum;
    private double cRate;    // 배터리 잔량
    private Integer cycle;      // 배터리 사이클
    private double distance;   // 누적 거리

    // 현재 작업 상태
    private String fromLoc;
    private String toLoc;
    private String status;      // waiting, unloading, driving, complete, charging, cooling

    // 온도 로그 (최근 10개) → [ [온도, 시간], ... ]
    private List<List<Object>> tempLogs;

    // 금일 가동률
    private Integer totalCount;
    private Integer runCount;
    private Integer waitCount;
    private Integer loadCount;
    private Integer chargeCount;
    private Integer coolingCount;

}