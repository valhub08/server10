package com.example.server10.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedResourceController {

    @Operation(summary = "보호된 자원 접근", description = "인증된 사용자만 접근 가능한 자원")
    @ApiResponse(responseCode = "200", description = "자원 접근 성공")

    @GetMapping("/protected/resource")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("This is a protected resource.");
    }

}