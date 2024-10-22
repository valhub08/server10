package com.example.server10.controller;

import com.example.server10.dto.LoginDto;
import com.example.server10.dto.TokenDto;
import com.example.server10.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Validated
public class TestController {
    private final AuthService authService;

    @Operation(summary = "공개된 엔드포인트", description = "JWT 인증 없이 접근 가능한 엔드포인트")
    @ApiResponse(responseCode = "200", description = "접근 성공")
    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("이 엔드포인트는 공개되어 있으며 인증이 필요하지 않습니다.");
    }

    @Operation(summary = "보호된 엔드포인트", description = "JWT 인증이 필요한 엔드포인트",
            security = {@SecurityRequirement(name = "Bearer Authentication")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "인증 성공",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TokenDto.class))}),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("이 엔드포인트는 JWT 인증이 필요합니다.");

    }
}