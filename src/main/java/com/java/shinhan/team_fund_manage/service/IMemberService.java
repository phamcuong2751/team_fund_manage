package com.java.shinhan.team_fund_manage.service;

import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.DeleteMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.UpdateMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;

public interface IMemberService {
    BaseResponse getAllMember();

    BaseResponse addMember(AddMemberRequest member);

    BaseResponse updateMember(UpdateMemberRequest member);

    BaseResponse deleteMember(DeleteMemberRequest member);

    BaseResponse getMember(MemberEntity member);
}
