package com.example.demo.mapper;

import com.example.demo.model.Home;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HomeMapper {
    List<Home> getBatteryData();
    List<Home> getBatteryAlertData();
}