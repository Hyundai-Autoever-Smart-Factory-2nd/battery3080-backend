package com.example.demo.mapper;

import com.example.demo.model.ModelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModelInfoMapper {

    List<ModelInfo> findAll();

    ModelInfo findById(@Param("modelInfosId") Long modelInfosId);

    void insert(ModelInfo modelInfo);

    void update(ModelInfo modelInfo);

    void delete(@Param("modelInfosId") Long modelInfosId);

}
