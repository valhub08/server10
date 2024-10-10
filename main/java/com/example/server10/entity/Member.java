package com.example.server10.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member") // 테이블 이름 명시
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id") // 컬럼 이름 지정
    private Long id;

    @Column(name = "email", nullable = false, unique = true) // 컬럼 이름 지정
    private String email;

    @Column(name = "password", nullable = false) // 컬럼 이름 지정
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false) // 컬럼 이름 지정
    private Authority authority;

    @Builder
    public Member(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}