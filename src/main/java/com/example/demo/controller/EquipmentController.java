package com.example.demo.controller;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusGroupedResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * 전체 장비 리스트 조회
     * Request: GET /api/equipments/status?equipmentId=1&factoryId=1&page=0&size=6
     * Response: List<EquipmentStatusResponse>
     */
    @GetMapping("/status")
    public EquipmentStatusGroupedResponse getEquipmentStatus(
            @RequestParam("equipmentId") Long equipmentId,
            @RequestParam("factoryId") Long factoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size
    ) {
        return equipmentService.getEquipmentStatus(equipmentId, factoryId, page, size);
    }

    /**
     * 장비 상세 조회 API
     * Request: GET /api/equipments/{modelInfosId}/detail
     * Response: EquipmentDetailResponse
     */
    @GetMapping("/{modelInfosId}/detail")
    public EquipmentDetailResponse getEquipmentDetail(
            @PathVariable("modelInfosId") Long modelInfosId
    ) {
        return equipmentService.getEquipmentDetail(modelInfosId);
    }
}
