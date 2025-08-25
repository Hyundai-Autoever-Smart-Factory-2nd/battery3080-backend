package com.example.demo.controller;

import com.example.demo.model.Home;
import com.example.demo.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/home")
public class HomeController {

    private final HomeService homeService;

    // 생성자를 통한 주입
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // AGV 평균 배터리
    @GetMapping("/avgBattery")
    public Home getAvgBattery() {
        return homeService.getBatteryData();
    }

    // 장비별 배터리 경고 수
    @GetMapping("/alertData")
    public List<Home> getAlertData() {
        return homeService.getAlertData();
    }
}