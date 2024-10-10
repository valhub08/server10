package com.example.server10.controller;

import com.example.server10.dto.LoginDto;
import com.example.server10.dto.TokenDto;
import com.example.server10.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthLoginController {
    private final AuthService authService;

    /**
     * 로그인 엔드포인트
     *
     * @param loginDto 로그인 요청 DTO
     * @return 토큰 응답 DTO
     */
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }
}




