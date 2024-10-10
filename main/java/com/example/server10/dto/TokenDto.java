package com.example.server10.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long accessTokenExpiresIn;
    private String refreshToken;

    @Builder
    public TokenDto(String grantType, String accessToken, Long accessTokenExpiresIn, String refreshToken) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.refreshToken = refreshToken;
    }
}