package com.java.shinhan.team_fund_manage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class TransactionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "transaction_category", nullable = false)
    private TrxCategoryEntity transactionCategory;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private Long amount ;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name = "update_at")
    private LocalDateTime updateAt = LocalDateTime.now();
}
