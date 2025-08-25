//package com.example.demo.service;
//
//import com.example.demo.mapper.HomeMapper;
//import com.example.demo.model.Home;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HomeService {
//
//    private final HomeMapper homeMapper;
//
//    private Home cachedBatteryData;
//    private List<Home> cachedAlertData;
//
//    // 생성자를 통한 주입
//    public HomeService(HomeMapper homeMapper) {
//        this.homeMapper = homeMapper;
//    }
//
//    // 1분마다 데이터 갱신
//    @Scheduled(fixedRate = 60000)
//    public void updateData() {
//        List<Home> batteryData = homeMapper.getBatteryData();
//        List<Home> alertData = homeMapper.getBatteryAlertData();
//
//        if (!batteryData.isEmpty()) {
//            cachedBatteryData = batteryData.get(0);
//        }
//        cachedAlertData = alertData;
//    }
//
//    public Home getBatteryData() {
//        return cachedBatteryData;
//    }
//
//    public List<Home> getAlertData() {
//        return cachedAlertData;
//    }
//}

package com.example.demo.service;

import com.example.demo.model.Home;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HomeService {

    private final Random random = new Random();

    private Home cachedBatteryData;
    private List<Home> cachedAlertData;

    public HomeService() {
        // 초기 데이터 생성
        updateData();
    }

    // 1분마다 데이터 갱신 (테스트용으로 60000ms = 1분)
    @Scheduled(fixedRate = 60000)
    public void updateData() {
        // AGV 평균 배터리 랜덤 값 (0~100)
        double avgBattery = Math.round(random.nextDouble() * 100 * 100.0) / 100.0;
        cachedBatteryData = new Home(avgBattery, 0, "Factory 1");

        // 장비별 배터리 경고 수 랜덤 생성 (0~10)
        cachedAlertData = new ArrayList<>();
        String[] equipmentNames = {"장비A", "장비B", "장비C"};
        for (String name : equipmentNames) {
            int alertCount = random.nextInt(11); // 0~10
            cachedAlertData.add(new Home(0, alertCount, name));
        }

        System.out.println("데이터 갱신됨: 평균 배터리=" + avgBattery);
    }

    public Home getBatteryData() {
        return cachedBatteryData;
    }

    public List<Home> getAlertData() {
        return cachedAlertData;
    }
}