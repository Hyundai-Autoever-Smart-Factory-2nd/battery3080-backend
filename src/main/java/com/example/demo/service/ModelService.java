package com.example.demo.service;

import com.example.demo.dto.ModelDetailResponse;
import com.example.demo.mapper.ModelMapper;
import com.example.demo.model.Model;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    private final ModelMapper modelMapper;

    public ModelService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ModelDetailResponse getModelDetail(Long modelId) {
        Model model = modelMapper.findById(modelId);

        return new ModelDetailResponse(
                model.getModelId(),
                model.getEquipmentId(),
                model.getWeight(),
                model.getSpeed(),
                model.getImage(),
                model.getWidth(),
                model.getLength(),
                model.getHeight()
        );
    }
}
