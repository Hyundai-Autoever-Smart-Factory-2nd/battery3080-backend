package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {
    
    @Select("SELECT COUNT(DISTINCT m.model_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE dl.temp>70 AND m.equipment_id = 1")
    Long getAgvBatteryWrong();

    @Select("SELECT COUNT(DISTINCT m.model_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE dl.temp>70 AND m.equipment_id = 3")
    Long getRobotArmBatteryWrong();

    @Select("SELECT COUNT(DISTINCT m.model_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE dl.temp>70 AND m.equipment_id = 2")
    Long getLiftCarBatteryWrong();

    @Select("SELECT COUNT(DISTINCT m.model_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE dl.temp>70 AND m.equipment_id = 4")
    Long getEtcBatteryWrong();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 1 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory1AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 3 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory1RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 2 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory1LiftAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 1 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory2AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 3 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory2RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 2 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory2LiftAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 1 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory3AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 3 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory3RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN data_logs dl ON mi.model_infos_id = dl.model_infos_id " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 2 " +
            "AND dl.timestamp = ( " +
            "    SELECT MAX(dl2.timestamp) " +
            "    FROM data_logs dl2 " +
            "    WHERE dl2.model_infos_id = mi.model_infos_id " +
            ")")
    Double getFactory3LiftAvg();
}