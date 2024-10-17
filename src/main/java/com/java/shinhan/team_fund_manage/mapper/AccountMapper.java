package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import com.java.shinhan.team_fund_manage.payload.request.accountRequest.AddAccountRequest;
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

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "member.id", source = "memberId")
    AccountEntity getRequestToEntity(AddAccountRequest request);
}
