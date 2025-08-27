package com.example.demo.controller;

import com.example.demo.dto.ModelDetailResponse;
import com.example.demo.service.ModelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    /**
     * 모델 상세 조회
     * Request: GET /api/models/{modelId}/detail
     * Response: ModelDetailResponse
     */
    @GetMapping("/{modelId}/detail")
    public ModelDetailResponse getModelDetail(@PathVariable("modelId") Long modelId) {
        return modelService.getModelDetail(modelId);
    }
}
