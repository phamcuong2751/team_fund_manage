package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.mapper.MemberMapper;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.repository.MemberRepository;
import com.java.shinhan.team_fund_manage.service.IMemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public BaseResponse getAllMember() {
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), memberRepository.findAll());
    }

    @Override
    public BaseResponse addMember(AddMemberRequest member) {
        MemberEntity entity = MemberMapper.INSTANCE.requestToEntity(member);
        memberRepository.save(entity);
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.INSERT_SUCCESS.getMessage());
    }

    @Override
    public BaseResponse updateMember(MemberEntity member) {
        return null;
    }

    @Override
    public BaseResponse deleteMember(MemberEntity member) {
        return null;
    }

    @Override
    public BaseResponse getMember(MemberEntity member) {
        return null;
    }
}
