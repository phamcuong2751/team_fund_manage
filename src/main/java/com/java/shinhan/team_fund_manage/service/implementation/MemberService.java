package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.constaints.MemberStatus;
import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.mapper.MemberMapper;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.UpdateMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.payload.response.memberResponse.AddMemberResponse;
import com.java.shinhan.team_fund_manage.payload.response.memberResponse.GetAllMemberResponse;
import com.java.shinhan.team_fund_manage.repository.MemberRepository;
import com.java.shinhan.team_fund_manage.service.IMemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    @Override
    public BaseResponse getAllMember() {
        List<MemberEntity> allMembers = memberRepository.findAll();

        //Just get member still working
        List<GetAllMemberResponse> memberResponses = allMembers.stream().filter(member -> !"9".equals(member.getStatus())).map(MemberMapper.INSTANCE::getAllToResponse).collect(Collectors.toList());

        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), memberResponses);

    }

    @Override
    public BaseResponse addMember(AddMemberRequest member) {
        MemberEntity entity = MemberMapper.INSTANCE.requestToEntity(member);
        memberRepository.save(entity);
        AddMemberResponse response = MemberMapper.INSTANCE.addMemToResponse(entity);
        response.setStatus(MemberStatus.fromStatus(response.getStatus()));

        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.INSERT_SUCCESS.getMessage(), response);
    }

    @Override
    public BaseResponse updateMember(UpdateMemberRequest request) {
        // Fetch the member by ID
        Optional<MemberEntity> optionalMember = memberRepository.findById(request.getId());

        if (optionalMember.isEmpty()) {
            return BaseResponseBuilder.build(HttpStatusCode.NOT_FOUND.code, ApiLabel.NOT_FOUND.getMessage(), ApiLabel.MEM_NOT_FOUND.text);
        }

        MemberEntity member = optionalMember.get();
        MemberMapper.INSTANCE.updateRequestToMember(request);
        member.setUpdateAt(LocalDateTime.now());
        memberRepository.save(member);

        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.UPDATE_SUCCESS.getMessage());
    }

    @Override
    public BaseResponse deleteMember(Long id) {
        Optional<MemberEntity> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            MemberEntity entity = optionalMember.get();

            //Check status if status is "9" termination request
            if (MemberStatus.COMPANY_OUT.status.equals(entity.getStatus())) {
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
    public BaseResponse getMemberByName(String name) {
        String sqlName = '%' + name + '%';

        List<MemberEntity> members = memberRepository.findByNameLikeAndStatusIsNot(sqlName, MemberStatus.COMPANY_OUT.status);
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), members);
    }
}
