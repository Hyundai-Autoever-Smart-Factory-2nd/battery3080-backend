package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {
    @Select("SELECT AVG(battery) FROM agv WHERE factory_id = 1")
    Double getFactory1AvgBattery();

    @Select("SELECT AVG(battery) FROM agv WHERE factory_id = 2")
    Double getFactory2AvgBattery();

    @Select("SELECT AVG(battery) FROM agv WHERE factory_id = 3")
    Double getFactory3AvgBattery();

    @Select("SELECT COUNT(*) FROM agv WHERE battery < 20")
    Long getBatteryWarningCount();
}