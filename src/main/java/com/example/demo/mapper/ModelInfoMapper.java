package com.example.demo.mapper;

import com.example.demo.dto.EquipmentDetailResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ModelInfoMapper {
    /**
     * 장비 기본/상세 조회 (model_num, battery, cycle, distance, from_loc, to_loc, status)
     * 마지막 로그 기준
     */
    EquipmentDetailResponse getEquipmentDetail(@Param("modelInfosId") Long modelInfosId);

    /**
     * 온도 로그 최근 10개
     * → [{temp: 35, timestamp: "..."}, ...]
     */
    List<Map<String, Object>> getTemperatureLogs(@Param("modelInfosId") Long modelInfosId);

    /**
     * 오늘 상태별 카운트
     * → {totalCount: 200, runCount: 120, waitCount: 30, ...}
     */
    Map<String, Object> getTodayStatusCount(@Param("modelInfosId") Long modelInfosId);
}



//package com.example.demo.mapper;
//
//import com.example.demo.model.ModelInfo;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//
//@Mapper
//public interface ModelInfoMapper {
//
//    List<ModelInfo> findAll();
//
//    ModelInfo findById(@Param("modelInfosId") Long modelInfosId);
//
//    void insert(ModelInfo modelInfo);
//
//    void update(ModelInfo modelInfo);
//
//    void delete(@Param("modelInfosId") Long modelInfosId);
//
//}
