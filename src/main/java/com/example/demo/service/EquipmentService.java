package com.example.demo.service;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.model.Equipment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class EquipmentService {

    // TODO: 실제로는 Mapper를 통해 DB 연동
    public EquipmentStatusResponse getEquipmentStatus(Long equipmentId, Long factoryId, int page, int size) {
        // 여기서는 샘플 데이터
        return new EquipmentStatusResponse(
                Collections.singletonList(new Equipment()), // goodList
                Collections.emptyList(),                   // warningList
                Collections.emptyList()                    // dangerList
        );
    }

    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
        return new EquipmentDetailResponse(
                modelInfosId,
                "AGV-01",
                "GOOD",
                85,
                LocalDateTime.now(),
                Arrays.asList("log1", "log2", "log3")
        );
    }
}
