package com.java.shinhan.team_fund_manage.service;

import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.AddTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.UpdateTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;

public interface ITrxCategoryService {
    BaseResponse getAll();
    BaseResponse getByName(String name);
    BaseResponse insert(AddTrxCategoryRequest request);
    BaseResponse update(UpdateTrxCategoryRequest request);
    BaseResponse delete(Long id);
}
