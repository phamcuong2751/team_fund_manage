package com.java.shinhan.team_fund_manage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity()
@Table(name = "member")
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt = LocalDateTime.now();

    @OneToMany(mappedBy = "member")
    private Set<AccountEntity> accounts;

    @OneToMany(mappedBy = "member")
    private Set<TransactionEntity> transaction;
}
