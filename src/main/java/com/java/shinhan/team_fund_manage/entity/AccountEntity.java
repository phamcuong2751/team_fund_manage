package com.java.shinhan.team_fund_manage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member", nullable = false)
    private MemberEntity member;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_code", unique = true)
    private String bankCode;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_no", unique = true)
    private String accountNo;

    @Column(name = "status")
    private String status;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt = LocalDateTime.now();
}
