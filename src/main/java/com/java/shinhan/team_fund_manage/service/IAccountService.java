package com.java.shinhan.team_fund_manage.service;

import com.java.shinhan.team_fund_manage.payload.request.accountRequest.AddAccountRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;

public interface IAccountService {
    BaseResponse getAllAccount();
    BaseResponse getAccount(String accountNo);
    BaseResponse insert(AddAccountRequest request);
    BaseResponse delete(String accountNo);
}
