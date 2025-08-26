package com.example.demo.service;

import com.example.demo.mapper.EquipmentMapper;
import com.example.demo.model.EquipmentModelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentMapper equipmentMapper) {
        this.equipmentMapper = equipmentMapper;
    }

    public List<EquipmentModelDTO> getAllData() {
        return equipmentMapper.getEquipmentModelData();
    }
}