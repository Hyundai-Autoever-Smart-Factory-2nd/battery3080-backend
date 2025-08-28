package com.example.demo.service;

import com.example.demo.global.ResponseDTO;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.model.Home;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Supplier;

@Service
public class HomeService {

    private final HomeMapper homeMapper;
    private final Random random = new Random();

    public HomeService(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    private Home createHome() {
        Home home = new Home();

        long agvWrong   = getOrRandomLong(homeMapper::getAgvBatteryWrong, 5);
        long robotWrong = getOrRandomLong(homeMapper::getRobotArmBatteryWrong, 5);
        long liftWrong  = getOrRandomLong(homeMapper::getLiftCarBatteryWrong, 5);
        long etcWrong   = getOrRandomLong(homeMapper::getEtcBatteryWrong, 5);

        long target = random.nextInt(10000) + 1L;
        long succeed = random.nextInt((int) target + 1);
        long failed = random.nextInt(10000) + 1L;
        long total = succeed + failed;

        home.setAchievement_target(target);
        home.setAchievement_achieved(succeed);
        home.setDefect_production(total);
        home.setDefect_defective(failed);

        home.setAgv_battery_wrong(agvWrong);
        home.setRobot_arm_battery_wrong(robotWrong);
        home.setLift_car_battery_wrong(liftWrong);
        home.setEtc_battery_wrong(etcWrong);
        home.setTotal_battery_wrong(agvWrong + robotWrong + liftWrong + etcWrong);

        home.setFactory1_agv_avg(getOrRandomDouble(homeMapper::getFactory1AgvAvg));
        home.setFactory1_robot_avg(getOrRandomDouble(homeMapper::getFactory1RobotAvg));
        home.setFactory1_lift_avg(getOrRandomDouble(homeMapper::getFactory1LiftAvg));

        home.setFactory2_agv_avg(getOrRandomDouble(homeMapper::getFactory2AgvAvg));
        home.setFactory2_robot_avg(getOrRandomDouble(homeMapper::getFactory2RobotAvg));
        home.setFactory2_lift_avg(getOrRandomDouble(homeMapper::getFactory2LiftAvg));

        home.setFactory3_agv_avg(getOrRandomDouble(homeMapper::getFactory3AgvAvg));
        home.setFactory3_robot_avg(getOrRandomDouble(homeMapper::getFactory3RobotAvg));
        home.setFactory3_lift_avg(getOrRandomDouble(homeMapper::getFactory3LiftAvg));

        return home;
    }

    private long getOrRandomLong(Supplier<Long> supplier, int maxRandom) {
        try {
            Long value = supplier.get();
            return value != null ? value : random.nextInt(maxRandom + 1);
        } catch (Exception e) {
            return random.nextInt(maxRandom + 1);
        }
    }

    private double getOrRandomDouble(Supplier<Double> supplier) {
        try {
            Double value = supplier.get();
            return value != null ? value : random.nextDouble() * 99 + 1;
        } catch (Exception e) {
            return random.nextDouble() * 99 + 1;
        }
    }

    public ResponseEntity<ResponseDTO<?>> getHomeData() {
        try {
            Home home = createHome();

            ResponseDTO<Home> successResponse = ResponseDTO.<Home>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .data(home)
                    .build();

            return ResponseEntity.ok(successResponse);

        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .success(false)
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .data("서버 내부 오류가 발생했습니다.")
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
