package com.java.shinhan.team_fund_manage.payload.response.accountResponse;

import lombok.Data;

@Data
public class GetAccountListResponse {
    private String memberName;
    private String bankName;
    private String bankCode;
    private String accountName;
    private String accountNo;
    private String status;
}
