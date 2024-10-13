package com.java.shinhan.team_fund_manage.payload.request.memberRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateMemberRequest {
    private Long id;
    private String name;
    private String phone;
    private String status;
    private String email;
    private LocalDate joinDate;
    private LocalDate birthday;
}
