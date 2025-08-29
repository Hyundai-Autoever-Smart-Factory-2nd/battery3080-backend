package com.example.demo.controller;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.service.EquipmentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.EquipmentStatusPageResponse;
import com.example.demo.global.ResponseDTO;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    /**
     * 장비 상태별 리스트 조회 API
     * Request: GET /api/equipments/{equipmentId}/factories/{factoryId}?status=(good / warning / danger)&page=0&size=6
     * Response: ResponseEntity<ResponseDTO<EquipmentStatusPageResponse>>
     */
    @GetMapping("/{equipmentId}/factories/{factoryId}")
    public ResponseEntity<ResponseDTO<EquipmentStatusPageResponse>> getEquipmentStatusByType(
            @PathVariable Long equipmentId,
            @PathVariable Long factoryId,
            @RequestParam String status,  // 양호(good), 주의(warning), 경고(danger)
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {

        EquipmentStatusPageResponse data = equipmentService.getEquipmentStatusByType(equipmentId, factoryId, page, size, status);
        
        ResponseDTO<EquipmentStatusPageResponse> response = ResponseDTO.<EquipmentStatusPageResponse>builder()
                .success(true)
                .status(200)
                .data(data)
                .build();
        
        return ResponseEntity.ok(response);
    }

    /**
     * 장비 상세 조회 API
     * Request: GET /api/equipments/{modelInfosId}
     * Response: ResponseEntity<ResponseDTO<EquipmentDetailResponse>>
     */
    @GetMapping("/{modelInfosId}")
    public ResponseEntity<ResponseDTO<EquipmentDetailResponse>> getEquipmentDetail(
            @PathVariable("modelInfosId") Long modelInfosId
    ) {
        EquipmentDetailResponse data = equipmentService.getEquipmentDetail(modelInfosId);
        
        ResponseDTO<EquipmentDetailResponse> response = ResponseDTO.<EquipmentDetailResponse>builder()
                .success(true)
                .status(200)
                .data(data)
                .build();
        
        return ResponseEntity.ok(response);
    }
}
