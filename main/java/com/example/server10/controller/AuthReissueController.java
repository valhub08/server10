package com.example.server10.controller;

import com.example.server10.dto.TokenDto;
import com.example.server10.dto.TokenRequestDto;
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
public class AuthReissueController {
    private final AuthService authService;

    /**
     * 토큰 재발급 엔드포인트
     *
     * @param tokenRequestDto 토큰 재발급 요청 DTO
     * @return 토큰 응답 DTO
     */
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@Valid @RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }


}


