package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import com.java.shinhan.team_fund_manage.payload.response.accountResponse.GetAccountListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy= ReportingPolicy.ERROR, componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(source = "member.name", target = "memberName")
    GetAccountListResponse  getAllEntityToResponse(AccountEntity entity);
}
