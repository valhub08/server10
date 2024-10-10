package com.example.server10.dto;

import com.example.server10.entity.Authority;
import com.example.server10.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 회원가입 요청 DTO
 */
@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "유효한 이메일 형식을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "권한을 입력해주세요.")
    private String authority;

    /**
     * 회원가입 시 사용할 Member 엔티티 생성 메서드
     *
     * @param passwordEncoder 비밀번호 인코더
     * @return 인코딩된 비밀번호를 가진 Member 엔티티
     */
    public Member toMember(PasswordEncoder passwordEncoder) {
        Authority auth;
        try {
            auth = Authority.valueOf(this.authority);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 권한입니다.");
        }

        return Member.builder().email(email).password(passwordEncoder.encode(password)).authority(auth).build();
    }
}
