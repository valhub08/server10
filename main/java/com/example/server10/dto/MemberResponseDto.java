package com.example.server10.dto;

import com.example.server10.entity.Authority;
import com.example.server10.entity.Member;
import lombok.Builder;
import lombok.Getter;

/**
 * 회원가입 응답 DTO
 */
@Getter
public class MemberResponseDto {
    private Long id;
    private String email;
    private Authority authority;

    @Builder
    public MemberResponseDto(Long id, String email, Authority authority) {
        this.id = id;
        this.email = email;
        this.authority = authority;
    }

    /**
     * Member 엔티티를 기반으로 MemberResponseDto 생성 메서드
     *
     * @param member Member 엔티티
     * @return MemberResponseDto 객체
     */
    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .authority(member.getAuthority())
                .build();
    }
}