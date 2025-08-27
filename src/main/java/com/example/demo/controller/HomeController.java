package com.example.demo.controller;

import com.example.demo.model.Home;
import com.example.demo.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/api/home")
    public List<Home> getHomeData() {
        return Collections.singletonList(homeService.getHomeData());
    }
}