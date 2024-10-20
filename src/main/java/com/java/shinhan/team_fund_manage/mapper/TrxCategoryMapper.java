package com.java.shinhan.team_fund_manage.mapper;

import com.java.shinhan.team_fund_manage.entity.TrxCategoryEntity;
import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.AddTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.response.trxCategoryResponse.GetAllTrxCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrxCategoryMapper {
    TrxCategoryMapper INSTANCE = Mappers.getMapper(TrxCategoryMapper.class);
    GetAllTrxCategoryResponse getAllToResponse(TrxCategoryEntity entity);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    TrxCategoryEntity addRequestToEntity(AddTrxCategoryRequest request);
}
