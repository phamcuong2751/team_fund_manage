package com.java.shinhan.team_fund_manage.constaints;

public enum MemberStatus {
    NOT_WORKING(0, "NOT_WORKING"),
    WORKING(1, "WORKING"),
    PROBATION(2, "PROBATION"),
    INTERNSHIP(3, "INTERNSHIP"),
    OUTSOURCE(4, "OUTSOURCE");

    public final int status;
    public final  String type;

    MemberStatus(int status, String type) {
        this.status = status;
        this.type = type;
    }
}
