
package com.example.demo.mapper;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.model.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface EquipmentMapper {
    List<EquipmentStatusResponse> findByEquipmentAndFactory(
            @Param("equipmentId") Long equipmentId,
            @Param("factoryId") Long factoryId,
            @Param("offset") int offset,
            @Param("size") int size
    );

    // 장비 기본/상세 조회
    EquipmentDetailResponse getEquipmentDetail(@Param("modelInfosId") Long modelInfosId);

    // 온도 로그 최근 10개
    List<Map<String, Object>> getTemperatureLogs(@Param("modelInfosId") Long modelInfosId);

    // 오늘 상태별 카운트
    Map<String, Object> getTodayStatusCount(@Param("modelInfosId") Long modelInfosId);// 장비 삭제
}
