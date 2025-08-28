package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {
    
    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp > 40 OR dl.temp < 15 AND m.equipment_id = 1")
    Long getAgvBatteryWrong();

    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp > 40 OR dl.temp < 15 AND m.equipment_id = 3")
    Long getRobotArmBatteryWrong();

    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp > 40 OR dl.temp < 15 AND m.equipment_id = 2")
    Long getLiftCarBatteryWrong();

    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp > 40 OR dl.temp < 15 AND m.equipment_id = 4")
    Long getEtcBatteryWrong();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 1")
    Double getFactory1AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 3")
    Double getFactory1RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 1 AND m.equipment_id = 2")
    Double getFactory1LiftAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 1")
    Double getFactory2AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 3")
    Double getFactory2RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 2 AND m.equipment_id = 2")
    Double getFactory2LiftAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 1")
    Double getFactory3AgvAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 3")
    Double getFactory3RobotAvg();

    @Select("SELECT AVG(dl.`c-rate`) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE mi.factory_id = 3 AND m.equipment_id = 2")
    Double getFactory3LiftAvg();
}