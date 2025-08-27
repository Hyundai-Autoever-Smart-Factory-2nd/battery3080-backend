package com.example.demo.global;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private boolean success;   // 요청 성공 여부
    private int status;        // HTTP Status Code
    private List<T> data;      // 응답 데이터 (리스트 형태)
}
