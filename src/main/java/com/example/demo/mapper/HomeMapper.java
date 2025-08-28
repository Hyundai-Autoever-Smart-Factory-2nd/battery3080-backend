package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HomeMapper {

    @Select("SELECT AVG(m.speed) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '1'")
    Double getFactory1AvgSpeed();

    @Select("SELECT AVG(m.speed) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '2'")
    Double getFactory2AvgSpeed();

    @Select("SELECT AVG(m.speed) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '3'")
    Double getFactory3AvgSpeed();

    @Select("SELECT AVG(m.weight) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '1'")
    Double getFactory1AvgWeight();

    @Select("SELECT AVG(m.weight) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '2'")
    Double getFactory2AvgWeight();

    @Select("SELECT AVG(m.weight) " +
            "FROM models m " +
            "JOIN model_infos mi ON m.model_id = mi.model_id " +
            "WHERE mi.factory_id = '3'")
    Double getFactory3AvgWeight();

    @Select("SELECT COUNT(*) FROM model_fix_log")
    Long getModelFixCount();
}