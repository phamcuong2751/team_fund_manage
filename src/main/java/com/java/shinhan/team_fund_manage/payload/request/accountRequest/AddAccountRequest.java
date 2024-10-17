package com.java.shinhan.team_fund_manage.payload.request.accountRequest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddAccountRequest {
    private Long memberId;
    private String bankName;
    private String bankCode;
    private String accountName;
    private String accountNo;
    private String status;
}
