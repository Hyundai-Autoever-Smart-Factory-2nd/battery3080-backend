package com.example.demo.service;

import com.example.demo.global.ResponseDTO;
import com.example.demo.model.Home;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HomeService {

    private final Random random = new Random();

    private Home createHomeData() {
        Home home = new Home();

        long target = random.nextInt(10000) + 1L;
        long succeed = random.nextInt((int) target + 1);
        long failed = random.nextInt(10000) + 1L;
        long total = succeed + failed;

        home.setAchievement_target(target);
        home.setAchievement_achieved(succeed);
        home.setDefect_production(failed);
        home.setDefect_defective(total);

        home.setTotal_production(getOrRandom("total_production"));
        home.setLine_a_production(getOrRandom("line_a_production"));
        home.setLine_b_production(getOrRandom("line_b_production"));
        home.setLine_c_production(getOrRandom("line_c_production"));
        home.setLine_d_production(getOrRandom("line_d_production"));
        home.setQuality_defective(getOrRandom("quality_defective"));
        home.setQuality_rework(getOrRandom("quality_rework"));
        home.setQuality_waste(getOrRandom("quality_waste"));
        home.setOperation_workers(getOrRandom("operation_workers"));
        home.setOperation_equipment(getOrRandom("operation_equipment"));
        home.setOperation_downtime(getOrRandom("operation_downtime"));
        home.setResource_material(getOrRandom("resource_material"));
        home.setResource_energy(getOrRandom("resource_energy"));
        home.setResource_efficiency(getOrRandom("resource_efficiency"));

        return home;
    }

    private int getOrRandom(String key) {
        Integer dbValue = null;
        return (dbValue != null) ? dbValue : random.nextInt(100) + 1;
    }

    public ResponseEntity<ResponseDTO<?>> getHomeData() {
        try {
            Home home = createHomeData();

            if (home == null) {
                ResponseDTO<String> failResponse = ResponseDTO.<String>builder()
                        .success(false)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .data("요청한 데이터를 생성할 수 없습니다.")
                        .build();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failResponse);
            }

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

