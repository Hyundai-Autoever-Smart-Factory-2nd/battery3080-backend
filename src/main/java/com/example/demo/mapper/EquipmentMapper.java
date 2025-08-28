
package com.example.demo.mapper;

import com.example.demo.dto.EquipmentDetailResponse;
import com.example.demo.dto.EquipmentStatusResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface EquipmentMapper {
    // 장비별, 공장별, 상태별 조회 (페이징 포함)
    List<EquipmentStatusResponse> findByEquipmentAndFactoryWithStatus(
            @Param("equipmentId") Long equipmentId,
            @Param("factoryId") Long factoryId,
            @Param("status") String status,
            @Param("offset") int offset,
            @Param("size") int size
    );
    
    // 상태별 총 개수 조회
    int countByEquipmentAndFactoryWithStatus(
            @Param("equipmentId") Long equipmentId,
            @Param("factoryId") Long factoryId,
            @Param("status") String status
    );

    // 장비 기본/상세 조회
    EquipmentDetailResponse getEquipmentDetail(@Param("modelInfosId") Long modelInfosId);

    // 온도 로그 최근 10개
    List<Map<String, Object>> getTemperatureLogs(@Param("modelInfosId") Long modelInfosId);

    // 오늘 상태별 카운트
    Map<String, Object> getTodayStatusCount(@Param("modelInfosId") Long modelInfosId);// 장비 삭제
}
