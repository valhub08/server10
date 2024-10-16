package com.example.server10.controller;

import com.example.server10.dto.MemberRequestDto;
import com.example.server10.dto.MemberResponseDto;
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
public class AuthSignupController {
    private final AuthService authService;

    @Operation(summary = "회원가입 요청", description = "사용자 회원가입 처리")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MemberResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
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


