package com.example.demo.service;

import com.example.demo.mapper.HomeMapper;
import com.example.demo.model.Home;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HomeService {

    private final HomeMapper homeMapper;
    private final Random random = new Random();

    public HomeService(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    public Home getHomeData() {
        long target = random.nextInt(10000) + 1L;
        long succeed = random.nextInt(10000) + 1L;
        long failed = random.nextInt(10000) + 1L;
        long total = random.nextInt(10000) + 1L;

        Double factory1Avg = homeMapper.getFactory1AvgBattery();
        Double factory2Avg = homeMapper.getFactory2AvgBattery();
        Double factory3Avg = homeMapper.getFactory3AvgBattery();
        Long batteryWarning = homeMapper.getBatteryWarningCount();

        return new Home(
                target,
                succeed,
                failed,
                total,
                batteryWarning != null ? batteryWarning : 0L,
                factory1Avg != null ? Math.round(factory1Avg * 100.0) / 100.0 : 0,
                factory2Avg != null ? Math.round(factory2Avg * 100.0) / 100.0 : 0,
                factory3Avg != null ? Math.round(factory3Avg * 100.0) / 100.0 : 0
        );
    }
}