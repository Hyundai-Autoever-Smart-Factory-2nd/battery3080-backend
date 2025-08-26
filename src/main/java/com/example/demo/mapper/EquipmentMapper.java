//DB로부터 값을 받고 출력 확인하기 위한 코드 Equipment~가 이에 해당

package com.example.demo.mapper;

import com.example.demo.model.EquipmentModelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EquipmentMapper {

    @Select("SELECT mi.model_infos_id AS modelId, mi.model_num AS modelNum, mi.factory_id AS factoryId, " +
            "m.weight AS weight, m.speed AS speed, e.name AS equipmentName, mi.installed_at AS installedAt " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN equipments e ON m.equipment_id = e.equipment_id " +
            "LIMIT 50")
    List<EquipmentModelDTO> getEquipmentModelData();
}