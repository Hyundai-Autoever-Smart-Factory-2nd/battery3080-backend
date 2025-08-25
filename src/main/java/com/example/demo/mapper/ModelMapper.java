package com.example.demo.mapper;

import com.example.demo.model.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModelMapper {

    List<Model> findAll();

    Model findById(@Param("modelId") Long modelId);

    List<Model> findByEquipmentId(@Param("equipmentId") Long equipmentId);

    void insert(Model model);

    void update(Model model);

    void delete(@Param("modelId") Long modelId);
}
