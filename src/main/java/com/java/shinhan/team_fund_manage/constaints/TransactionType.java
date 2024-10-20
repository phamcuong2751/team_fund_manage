package com.java.shinhan.team_fund_manage.constaints;

public enum TransactionType {
    INCOME("1", "Income transaction"),
    OUTCOME("2", "Outcome transaction"),
    ;
    private String type;
    private String content;
    TransactionType(String type, String content) {
        this.type = type;
        this.content = content;
    }
}
