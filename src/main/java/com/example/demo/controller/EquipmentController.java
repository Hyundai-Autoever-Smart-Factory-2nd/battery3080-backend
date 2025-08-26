package com.example.demo.controller;

import com.example.demo.model.EquipmentModelDTO;
import com.example.demo.service.EquipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/api/equipment-models")
    public List<EquipmentModelDTO> getEquipmentModels() {
        return equipmentService.getAllData();
    }
}