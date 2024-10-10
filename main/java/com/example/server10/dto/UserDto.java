package com.example.server10.dto;

import com.example.server10.entity.Authority;
import com.example.server10.entity.Member;
import lombok.Builder;
import lombok.Getter;

/**
 * 사용자 정보 DTO
 */
@Getter
public class UserDto {
    private Long id;
    private String email;
    private Authority authority;

    @Builder
    public UserDto(Long id, String email, Authority authority) {
        this.id = id;
        this.email = email;
        this.authority = authority;
    }

    /**
     * Member 엔티티를 기반으로 UserDto 생성 메서드
     *
     * @param member Member 엔티티
     * @return UserDto 객체
     */
    public static UserDto of(Member member) {
        return UserDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .authority(member.getAuthority())
                .build();
    }
}