package com.java.shinhan.team_fund_manage.payload.request.memberRequest;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class DeleteMemberRequest {
    private Long id;
    private String name;
    private String status;
}
