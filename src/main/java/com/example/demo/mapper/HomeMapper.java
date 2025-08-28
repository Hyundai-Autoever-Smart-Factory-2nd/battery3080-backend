package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {
    
    /**
     * Counts models whose latest data log reports a temperature above 70 for AGV equipment (equipment_id = 1).
     *
     * The query considers only the most recent data_log per model_infos_id and returns the count as a Long (0 if none).
     *
     * @return the number of model_infos with latest data_log.temp > 70 for AGV equipment
     */
    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp NOT BETWEEN 15 AND 40 AND m.equipment_id = 1")
    Long getAgvBatteryWrong();

    /**
     * Counts models (by model_infos_id) whose latest data_log shows temperature > 70 for robot arms.
     *
     * Computes the number of distinct model_infos entries whose most recent data_logs (by timestamp)
     * have temp > 70 and whose associated model has equipment_id = 3. Returns 0 if none match.
     *
     * @return the count of model_infos with a latest data_log temperature over 70 for robot arm equipment
     */
    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp NOT BETWEEN 15 AND 40 AND m.equipment_id = 3")
    Long getRobotArmBatteryWrong();

    /**
     * Counts models of equipment type 2 whose latest data_log records have temperature > 70.
     *
     * The count is computed per model_infos entry using only the most recent data_log for each model_infos_id.
     *
     * @return the number of model_infos whose latest data_log temperature exceeds 70 (may be zero)
     */
    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp NOT BETWEEN 15 AND 40 AND m.equipment_id = 2")
    Long getLiftCarBatteryWrong();

    /**
     * Counts models (based on the latest data_log per model_infos record) for equipment type 4 where the latest temperature exceeds 70.
     *
     * The query considers only the most recent data_log for each model_infos_id and returns the number of those records
     * whose `temp` > 70 for models with `equipment_id = 4`. Returns 0 when no matching records are found.
     *
     * @return the count of model_infos whose latest data_log has temp > 70 for equipment type 4
     */
    @Select("SELECT COUNT(dl.model_infos_id) " +
            "FROM model_infos mi " +
            "JOIN models m ON mi.model_id = m.model_id " +
            "JOIN (SELECT model_infos_id,MAX(timestamp) AS max_ts " +
            "FROM data_logs GROUP BY model_infos_id " +
            ") dl_max ON mi.model_infos_id = dl_max.model_infos_id " +
            "JOIN data_logs dl ON dl.model_infos_id = dl_max.model_infos_id AND dl.timestamp = dl_max.max_ts " +
            "WHERE dl.temp NOT BETWEEN 15 AND 40 AND m.equipment_id = 4")
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