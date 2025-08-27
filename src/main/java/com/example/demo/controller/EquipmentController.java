package com.example.demo.controller;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipments")

public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }


    /**
     * 전체 장비 리스트 조회
     * - 프론트엔드에서 1분 주기로 호출
     * - equipmentId(장비종류), factoryId(공장ID)별 상태 리스트 반환
     * - 상태별로(양호/주의/경고) 각각 6개씩 페이징 처리
     *
     * Request: GET /api/equipments/status?equipmentId=1&factoryId=1&page=0&size=6
     * Response: EquipmentStatusResponse (goodList, warningList, dangerList)
     */
    @GetMapping("/status")
    public EquipmentStatusResponse getEquipmentStatus(
            @RequestParam("equipmentId") Long equipmentId,
            @RequestParam("factoryId") Long factoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size
    ) {
        return equipmentService.getEquipmentStatus(equipmentId, factoryId, page, size);
    }

    /**
     * 장비 상세 조회 API
     * - 특정 장비를 클릭했을 때 사용
     *
     * Request: GET /api/equipments/{modelInfosId}/detail
     * Response: EquipmentDetailResponse
     */

    @GetMapping("/{modelInfosId}/detail")
    public EquipmentDetailResponse getEquipmentDetail(@PathVariable("modelInfosId") Long modelInfosId) {
        return equipmentService.getEquipmentDetail(modelInfosId);
    }
}
