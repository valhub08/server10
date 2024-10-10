package com.example.server10.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 토큰 재발급 요청 DTO
 */
@Getter
@NoArgsConstructor
public class TokenRequestDto {

    @NotBlank(message = "Access Token을 입력해주세요.")
    private String accessToken;

    @NotBlank(message = "Refresh Token을 입력해주세요.")
    private String refreshToken;
}