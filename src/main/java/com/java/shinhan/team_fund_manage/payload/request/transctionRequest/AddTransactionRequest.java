package com.java.shinhan.team_fund_manage.payload.request.transctionRequest;

import lombok.Data;

@Data
public class AddTransactionRequest {
    private Long member;
    private Long transactionCategory;
    private String transactionType;
    private String amount;
    private String transactionDate;
    private String description;
}
