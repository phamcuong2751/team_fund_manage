package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.constaints.MemberStatus;
import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.mapper.MemberMapper;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.DeleteMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.payload.response.memberResponse.AddMemberResponse;
import com.java.shinhan.team_fund_manage.repository.MemberRepository;
import com.java.shinhan.team_fund_manage.service.IMemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
        AddMemberResponse response  = MemberMapper.INSTANCE.entityToResponse(entity);
        response.setStatus(MemberStatus.fromStatus(response.getStatus()));
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.INSERT_SUCCESS.getMessage(), response);
    }

    @Override
    public BaseResponse updateMember(MemberEntity member) {
        return null;
    }

    @Override
    public BaseResponse deleteMember(DeleteMemberRequest member) {
        Optional<MemberEntity> optionalMember = memberRepository.findById(member.getId());
        if (optionalMember.isPresent()) {
            MemberEntity entity = optionalMember.get();

            //Check status if status is "9" termination request
            if (MemberStatus.COMPANY_OUT.status.equals(member.getStatus()) ) {
                return BaseResponseBuilder.build(HttpStatusCode.BAD_REQUEST.code, ApiLabel.MEM_ALREADY_TERMINATED.getMessage());
            }

            //Hard coding "9"
            entity.setStatus(MemberStatus.COMPANY_OUT.status);
            entity.setUpdateAt(LocalDateTime.now());

            memberRepository.save(entity);
            return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.DELETE_SUCCESS.getMessage());
        } else {
            return BaseResponseBuilder.build(HttpStatusCode.BAD_REQUEST.code, ApiLabel.MEM_NOT_FOUND.getMessage());
        }

    }

    @Override
    public BaseResponse getMember(MemberEntity member) {
        return null;
    }
}
