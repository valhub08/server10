package com.example.server10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "refresh_token") // 테이블 이름 명시
public class RefreshToken {

    @Id
    @Column(name = "rt_key") // 컬럼 이름 지정
    private String key;

    @Column(name = "rt_value") // 컬럼 이름 지정
    private String value;

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * RefreshToken 값 업데이트 메서드
     *
     * @param token 새로운 RefreshToken 값
     * @return 업데이트된 RefreshToken 객체
     */
    public RefreshToken updateValue(String token) {
        this.value = token;
        return this;
    }
}