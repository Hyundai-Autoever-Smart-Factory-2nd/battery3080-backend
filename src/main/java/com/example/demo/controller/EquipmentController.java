package com.example.demo.controller;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.service.EquipmentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.EquipmentStatusPageResponse;
import com.example.demo.global.ResponseDTO;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    /**
     * 전체 장비 리스트 조회
     * Request: GET /api/equipments/status?equipmentId=1&factoryId=1&page=0&size=6
     * Response: List<EquipmentStatusResponse>
     */

    @GetMapping("/{equipmentId}/factories/{factoryId}/status/{status}")
    public EquipmentStatusPageResponse getEquipmentStatusByType(
            @PathVariable Long equipmentId,
            @PathVariable Long factoryId,
            @PathVariable String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {

        return equipmentService.getEquipmentStatusByType(equipmentId, factoryId, page, size, status);
    }

    /**
     * 장비 상세 조회 API
     * Request: GET /api/equipments/{modelInfosId}
     * Response: EquipmentDetailResponse
     */

    @GetMapping("/{modelInfosId}")
    public EquipmentDetailResponse getEquipmentDetail(
            @PathVariable("modelInfosId") Long modelInfosId
    ) {
        return equipmentService.getEquipmentDetail(modelInfosId);
    }
}
