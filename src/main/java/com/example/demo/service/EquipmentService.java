package com.example.demo.service;
import com.example.demo.dto.EquipmentStatusPageResponse;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.mapper.EquipmentMapper;
import com.example.demo.mapper.ModelInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    private final EquipmentMapper equipmentMapper;
    private final ModelInfoMapper modelInfoMapper;
    private final Random random = new Random();

    public EquipmentService(EquipmentMapper equipmentMapper, ModelInfoMapper modelInfoMapper) {
        this.equipmentMapper = equipmentMapper;
        this.modelInfoMapper = modelInfoMapper;
    }
//    public List<EquipmentStatusResponse> getEquipmentStatusByType(
//            Long equipmentId, Long factoryId, int page, int size, String statusType) {
public EquipmentStatusPageResponse getEquipmentStatusByType(
        Long equipmentId, Long factoryId, int page, int size, String statusType) {

        int offset = page * size;

        // DB에서 장비 목록 조회
        List<EquipmentStatusResponse> rawList =
                equipmentMapper.findByEquipmentAndFactory(equipmentId, factoryId, offset, size);

        // 상태 계산 후 매핑
        List<EquipmentStatusResponse> updatedList = rawList.stream()
                .map(item -> {
                    double temp = item.getTemp();
                    double cRate  = item.getCRate();

                    String status
                            = (item.getTemp() <= 0 || item.getTemp() >= 60) ? "DANGER" :
                            ((item.getTemp() > 0 && item.getTemp() <= 15) || (item.getTemp() > 40 && item.getTemp() < 60)) ? "WARNING" :
                                    "GOOD";
                    return new EquipmentStatusResponse(
                            item.getEquipmentId(),
                            item.getModelInfosId(),
                            item.getModelNum(),
                            item.getTemp(),
                            item.getCRate(),
                            status
                    );
                })
                .collect(Collectors.toList());

        // 요청한 상태만 필터링
        List<EquipmentStatusResponse> filteredList = updatedList.stream()
                .filter(e -> e.getStatus().equalsIgnoreCase(statusType))
                .collect(Collectors.toList());

        int totalCount = filteredList.size(); // 상태별 총 개수

        // 페이징 적용
        List<EquipmentStatusResponse> pagedList = filteredList.stream()
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());

        // totalCount + data 반환
        return new EquipmentStatusPageResponse(totalCount, pagedList);
    }
    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
        EquipmentDetailResponse detail = equipmentMapper.getEquipmentDetail(modelInfosId);

        // 온도 로그 변환 부분
        List<Map<String, Object>> rawTempLogs = equipmentMapper.getTemperatureLogs(modelInfosId);
        List<List<Object>> formattedLogs = rawTempLogs.stream()
                .map(entry -> List.of(
                        entry.get("temp"),      // 온도 값
                        entry.get("timestamp")  // 시간 값
                ))
                .toList();
        detail.setTempLogs(formattedLogs);

        // 오늘 상태별 카운트 매핑
        Map<String, Object> statusCount = equipmentMapper.getTodayStatusCount(modelInfosId);
        detail.setTotalCount(((Number) statusCount.get("totalCount")).intValue());
        detail.setRunCount(((Number) statusCount.get("runCount")).intValue());
        detail.setWaitCount(((Number) statusCount.get("waitCount")).intValue());
        detail.setLoadCount(((Number) statusCount.get("loadCount")).intValue());
        detail.setChargeCount(((Number) statusCount.get("chargeCount")).intValue());
        detail.setCoolingCount(((Number) statusCount.get("coolingCount")).intValue());

        return detail;
    }

//    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
//        ModelInfo modelInfo = modelInfoMapper.findById(modelInfosId);
//
//        return new EquipmentDetailResponse(
//                modelInfo.getModelInfosId(),
//                modelInfo.getModelNum(),
//                "GOOD",
//                85,
//                LocalDateTime.now(),
//                List.of("log1", "log2", "log3")
//        );
//    }
}



