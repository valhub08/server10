package com.example.server10.controller;

import com.example.server10.dto.TokenDto;
import com.example.server10.dto.TokenRequestDto;
import com.example.server10.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "토큰 재발급 요청", description = "Access Token과 Refresh Token을 사용하여 새로운 토큰을 발급받습니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "토큰 재발급 성공",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TokenDto.class))}),
            @ApiResponse(responseCode = "401", description = "토큰 재발급 실패")
    })

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