package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "name", source = "name")
//    @Mapping(target = "status", source = "status")
//    @Mapping(target = "phone", source = "phone")
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "join_date", source = "join_date")
//    @Mapping(target = "birthday", source = "birthday")
    MemberEntity requestToEntity(AddMemberRequest request);
}
