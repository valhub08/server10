package com.example.server10.controller;

import com.example.server10.dto.LoginDto;
import com.example.server10.dto.TokenDto;
import com.example.server10.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    @Operation(summary = "로그인 요청", description = "사용자 로그인 처리")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TokenDto.class))}),
            @ApiResponse(responseCode = "401", description = "로그인 실패")
    })
//
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
//    @PostMapping("/auth/login")
//    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginDto loginDto) {
//        // 로그인 처리 로직 추가
//        return ResponseEntity.ok(new TokenDto("Bearer", "access-token", 3600L, "refresh-token"));
//        // return ResponseEntity.ok(authService.login(loginDto));
//    }
}