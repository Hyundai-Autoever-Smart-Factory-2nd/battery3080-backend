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

        Double f1Speed = homeMapper.getFactory1AvgSpeed();
        Double f2Speed = homeMapper.getFactory2AvgSpeed();
        Double f3Speed = homeMapper.getFactory3AvgSpeed();

        Double f1Weight = homeMapper.getFactory1AvgWeight();
        Double f2Weight = homeMapper.getFactory2AvgWeight();
        Double f3Weight = homeMapper.getFactory3AvgWeight();

        Long fixCount = homeMapper.getModelFixCount();

        Home home = new Home(
                target,
                succeed,
                failed,
                total,
                fixCount != null ? fixCount : 0L,
                0, 0, 0 // 예전 배터리 평균 대신 기본값 넣음
        );

        home.setFactory1_avg_speed(f1Speed != null ? Math.round(f1Speed * 100.0) / 100.0 : 0);
        home.setFactory2_avg_speed(f2Speed != null ? Math.round(f2Speed * 100.0) / 100.0 : 0);
        home.setFactory3_avg_speed(f3Speed != null ? Math.round(f3Speed * 100.0) / 100.0 : 0);

        home.setFactory1_avg_weight(f1Weight != null ? Math.round(f1Weight * 100.0) / 100.0 : 0);
        home.setFactory2_avg_weight(f2Weight != null ? Math.round(f2Weight * 100.0) / 100.0 : 0);
        home.setFactory3_avg_weight(f3Weight != null ? Math.round(f3Weight * 100.0) / 100.0 : 0);

        return home;
    }
}