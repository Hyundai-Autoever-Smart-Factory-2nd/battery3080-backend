package com.example.demo.controller;

import com.example.demo.global.ResponseDTO;
import com.example.demo.model.Home;
import com.example.demo.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class TestController {

    private final HomeService homeService;

    public TestController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/api/test")
    public ResponseEntity<ResponseDTO<Home>> getHomeData() {
        try {
            Home home = homeService.getHomeData();

            if (home == null) {
                ResponseDTO<Home> failResponse = ResponseDTO.<Home>builder()
                        .success(false)
                        .status(HttpStatus.NOT_FOUND.value())
                        .data(Collections.singletonList(
                                new Home() {{
                                    setTarget_object(0);
                                }}
                        ))
                        .build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failResponse);
            }

            ResponseDTO<Home> successResponse = ResponseDTO.<Home>builder()
                    .success(true)
                    .status(HttpStatus.OK.value())
                    .data(Collections.singletonList(home))
                    .build();

            return ResponseEntity.ok(successResponse);

        } catch (Exception e) {
            ResponseDTO<Home> errorResponse = ResponseDTO.<Home>builder()
                    .success(false)
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .data(Collections.singletonList(
                            new Home() {{
                                setTarget_object(0);
                            }}
                    ))
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}