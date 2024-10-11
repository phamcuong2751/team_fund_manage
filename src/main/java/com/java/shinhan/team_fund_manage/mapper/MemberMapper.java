package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.MemberEntity;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    MemberEntity requestToEntity(AddMemberRequest request);
}
