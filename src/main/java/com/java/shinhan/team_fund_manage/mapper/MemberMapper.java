package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.UpdateMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.memberResponse.AddMemberResponse;
import com.java.shinhan.team_fund_manage.payload.response.memberResponse.GetAllMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy=ReportingPolicy.ERROR, componentModel = "spring")
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    MemberEntity requestToEntity(AddMemberRequest request);
    AddMemberResponse addMemToResponse(MemberEntity entity);
    GetAllMemberResponse getAllToResponse(MemberEntity member);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    MemberEntity updateRequestToMember(UpdateMemberRequest request);
}
