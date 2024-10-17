package com.java.shinhan.team_fund_manage.constaints;

public enum AccountStatus {
    ACTIVE("1", "Active"),
    INACTIVE("2", "Inactive"),
    SUSPENDED("3", "Suspended"),
    CLOSED("4", "Closed"),
    PENDING("5", "Pending"),
    LOCKED("6", "Locked"),
    RESTRICTED("7", "Restricted"),
    DELETED("9", "Account is deleted!")
    ;

    public final String status;
    public final String content;

    AccountStatus(String status, String content) {
        this.status = status;
        this.content = content;
    }

    public static String fromStatus(String status) {
        try {
            for (AccountStatus accountStatus : AccountStatus.values()) {
                if (accountStatus.status.equals(status)) {
                    return accountStatus.content;
                }
            }
        } catch (IllegalArgumentException ignored) {
            return "";
        }
        return "";
    }
}
