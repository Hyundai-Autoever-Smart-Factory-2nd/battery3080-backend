package com.example.demo.controller;

import com.example.demo.global.ResponseDTO;
import com.example.demo.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/api/home")
    public ResponseEntity<ResponseDTO<?>> getHomeData() {
        return homeService.getHomeData(); // 라우팅만 담당
    }
}
