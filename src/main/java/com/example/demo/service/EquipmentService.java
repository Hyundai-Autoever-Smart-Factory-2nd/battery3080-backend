package com.example.demo.service;
import com.example.demo.dto.EquipmentStatusPageResponse;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.mapper.EquipmentMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentMapper equipmentMapper;

    public EquipmentStatusPageResponse getEquipmentStatusByType(
        Long equipmentId, Long factoryId, int page, int size, String status) {

        int offset = page * size;
        
        // DB에서 상태별 장비 목록 조회 (페이징 적용)
        List<EquipmentStatusResponse> equipmentList = 
            equipmentMapper.findByEquipmentAndFactoryWithStatus(equipmentId, factoryId, status, offset, size);
        
        // 총 개수 조회
        int totalCount = equipmentMapper.countByEquipmentAndFactoryWithStatus(equipmentId, factoryId, status);
        
        return new EquipmentStatusPageResponse(totalCount, equipmentList);
    }

    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
        EquipmentDetailResponse detail = equipmentMapper.getEquipmentDetail(modelInfosId);

        // ✅ 온도 로그 변환 부분
        List<Map<String, Object>> rawTempLogs = equipmentMapper.getTemperatureLogs(modelInfosId);
        List<List<Object>> formattedLogs = rawTempLogs.stream()
                .map(entry -> List.of(
                        entry.get("temp"),      // 온도 값
                        entry.get("timestamp")  // 시간 값
                ))
                .toList();
        detail.setTempLogs(formattedLogs);

        // ✅ 오늘 상태별 카운트 매핑
        Map<String, Object> statusCount = equipmentMapper.getTodayStatusCount(modelInfosId);
        detail.setTotalCount(((Number) statusCount.get("totalCount")).intValue());
        detail.setRunCount(((Number) statusCount.get("runCount")).intValue());
        detail.setWaitCount(((Number) statusCount.get("waitCount")).intValue());
        detail.setLoadCount(((Number) statusCount.get("loadCount")).intValue());
        detail.setChargeCount(((Number) statusCount.get("chargeCount")).intValue());
        detail.setCoolingCount(((Number) statusCount.get("coolingCount")).intValue());

        return detail;
    }
}



