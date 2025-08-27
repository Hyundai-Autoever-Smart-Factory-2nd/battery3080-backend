package com.example.demo.service;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusGroupedResponse;
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

    public EquipmentStatusGroupedResponse getEquipmentStatus(Long equipmentId, Long factoryId, int page, int size) {
        int offset = page * size;

        List<EquipmentStatusResponse> rawList =
                equipmentMapper.findByEquipmentAndFactory(equipmentId, factoryId, offset, size);

        List<EquipmentStatusResponse> updatedList = rawList.stream()
                .map(item -> {
                    int temp = random.nextInt(101); // 0~100 랜덤
                    String status = (temp >= 70) ? "GOOD"
                            : (temp >= 40) ? "WARNING"
                            : "DANGER";
                    return new EquipmentStatusResponse(
                            item.getEquipmentId(),
                            item.getName(),
                            item.getModelNum(),
                            temp,
                            status
                    );
                })
                .collect(Collectors.toList());

        List<EquipmentStatusResponse> goodList = updatedList.stream()
                .filter(e -> "GOOD".equals(e.getStatus()))
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());

        List<EquipmentStatusResponse> warningList = updatedList.stream()
                .filter(e -> "WARNING".equals(e.getStatus()))
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());

        List<EquipmentStatusResponse> dangerList = updatedList.stream()
                .filter(e -> "DANGER".equals(e.getStatus()))
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());

        return new EquipmentStatusGroupedResponse(goodList, warningList, dangerList);
    }


    public EquipmentDetailResponse getEquipmentDetail(Long modelInfosId) {
        ModelInfo modelInfo = modelInfoMapper.findById(modelInfosId);

        return new EquipmentDetailResponse(
                modelInfo.getModelInfosId(),
                modelInfo.getModelNum(),
                "GOOD",
                85,
                LocalDateTime.now(),
                List.of("log1", "log2", "log3")
        );
    }
}

//        List<Equipment> goodList = equipmentMapper.findByEquipmentAndFactory(equipmentId, factoryId, offset, size);
//        List<Equipment> warningList = List.of(); // TODO: 상태 조건 로직 추가
//        List<Equipment> dangerList = List.of();  // TODO: 상태 조건 로직 추가
//
//        return new EquipmentStatusResponse(goodList, warningList, dangerList);
//    }



