package com.example.demo.service;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.mapper.EquipmentMapper;
import com.example.demo.mapper.ModelInfoMapper;
import com.example.demo.model.Equipment;
import com.example.demo.model.ModelInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentMapper equipmentMapper;
    private final ModelInfoMapper modelInfoMapper;

    //하나의 생성자로 두 Mapper를 주입받기
    public EquipmentService(EquipmentMapper equipmentMapper, ModelInfoMapper modelInfoMapper) {
        this.equipmentMapper = equipmentMapper;
        this.modelInfoMapper = modelInfoMapper;
    }

    public EquipmentStatusResponse getEquipmentStatus(Long equipmentId, String factoryId, int page, int size) {
        int offset = page * size;

        List<Equipment> goodList = equipmentMapper.findByEquipmentAndFactory(equipmentId, factoryId, offset, size);
        List<Equipment> warningList = List.of(); // TODO: 상태 조건 로직 추가
        List<Equipment> dangerList = List.of();  // TODO: 상태 조건 로직 추가

        return new EquipmentStatusResponse(goodList, warningList, dangerList);
    }

    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
        ModelInfo modelInfo = modelInfoMapper.findById(modelInfosId);

        return new EquipmentDetailResponse(
                modelInfo.getModelInfosId(),
                modelInfo.getModelNum(),// ✅ DB 값 사용
                "GOOD",
                85,
                LocalDateTime.now(),
                List.of("log1", "log2", "log3")
        );
    }
}


