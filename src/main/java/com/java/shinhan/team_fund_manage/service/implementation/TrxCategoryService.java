package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.entity.TrxCategoryEntity;
import com.java.shinhan.team_fund_manage.mapper.TrxCategoryMapper;
import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.AddTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.UpdateTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.payload.response.trxCategoryResponse.GetAllTrxCategoryResponse;
import com.java.shinhan.team_fund_manage.repository.TrxCategoryRepository;
import com.java.shinhan.team_fund_manage.service.ITrxCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrxCategoryService implements ITrxCategoryService {
    private final TrxCategoryRepository trxCategoryRepository;

    public TrxCategoryService(TrxCategoryRepository trxCategoryRepository) {
        this.trxCategoryRepository = trxCategoryRepository;
    }

    @Override
    public BaseResponse getAll() {
        List<TrxCategoryEntity> trxCategories = trxCategoryRepository.findAll();
        List<GetAllTrxCategoryResponse> responses = trxCategories.stream().map(TrxCategoryMapper.INSTANCE::getAllToResponse).collect(Collectors.toList());
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), responses);
    }

    @Override
    public BaseResponse getByName(String name) {
        return null;
    }

    @Override
    public BaseResponse insert(AddTrxCategoryRequest request) {
        TrxCategoryEntity entity = TrxCategoryMapper.INSTANCE.addRequestToEntity(request);

        trxCategoryRepository.save(entity);

        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.INSERT_SUCCESS.getMessage());
    }

    @Override
    public BaseResponse update(UpdateTrxCategoryRequest request) {
        return null;
    }

    @Override
    public BaseResponse delete(Long id) {
        return null;
    }
}
