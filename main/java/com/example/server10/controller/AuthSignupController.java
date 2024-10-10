package com.example.server10.controller;

import com.example.server10.dto.MemberRequestDto;
import com.example.server10.dto.MemberResponseDto;
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
public class AuthSignupController {
    private final AuthService authService;

    /**
     * 회원가입 엔드포인트
     *
     * @param memberRequestDto 회원가입 요청 DTO
     * @return 회원가입 응답 DTO
     */
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }
}




