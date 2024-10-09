package com.java.shinhan.team_fund_manage.payload.request.memberRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class AddMemberRequest {
    private String name;
    private String phone;
    private String status;
    private String email;
    private LocalDate joinDate;
    private LocalDate birthday;
}
