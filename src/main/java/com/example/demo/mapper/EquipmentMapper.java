
package com.example.demo.mapper;

import com.example.demo.dto.EquipmentStatusResponse;
import com.example.demo.model.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface EquipmentMapper {
    List<Equipment> findAll();  // 전체 장비 조회

    Equipment findById(@Param("equipmentId") Long equipmentId);// 특정 장비 조회

    List<EquipmentStatusResponse> findByEquipmentAndFactory(
            @Param("equipmentId") Long equipmentId,
            @Param("factoryId") Long factoryId,
            @Param("offset") int offset,
            @Param("size") int size
    );

    void insert(Equipment equipment);  // 신규 장비 등록

    void update(Equipment equipment);  // 장비 수정

    void delete(@Param("equipmentId") Long equipmentId); // 장비 삭제
}
