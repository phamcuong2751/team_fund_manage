package com.java.shinhan.team_fund_manage.constaints;

public enum MemberStatus {
    NOT_WORKING("0", "NOT_WORKING"), WORKING("1", "WORKING"), PROBATION("2", "PROBATION"), INTERNSHIP("3", "INTERNSHIP"), OUTSOURCE("4", "OUTSOURCE"), COMPANY_OUT("9", "OUT_OF_COMPANY");

    public final String status;
    public final String type;

    MemberStatus(String status, String type) {
        this.status = status;
        this.type = type;
    }

    public static String fromStatus(String status) {
        try {
            for (MemberStatus memberStatus : MemberStatus.values()) {
                if (memberStatus.status.equals(status)) {
                    return memberStatus.type;
                }
            }
        } catch (IllegalArgumentException ignored) {
            return "";
        }
        return "";
    }
}
