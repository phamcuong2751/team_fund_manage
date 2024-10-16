package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import com.java.shinhan.team_fund_manage.mapper.AccountMapper;
import com.java.shinhan.team_fund_manage.payload.request.accountRequest.AddAccountRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.payload.response.accountResponse.GetAccountListResponse;
import com.java.shinhan.team_fund_manage.repository.AccountRepository;
import com.java.shinhan.team_fund_manage.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public BaseResponse getAllAccount() {
        List<AccountEntity> allAccount = accountRepository.findAll();
        List<GetAccountListResponse> responses = allAccount.stream().map(AccountMapper.INSTANCE::getAllEntityToResponse).collect(Collectors.toList());
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), responses);
    }

    @Override
    public BaseResponse getAccount(String account_no) {
        return null;
    }

    @Override
    public BaseResponse insert(AddAccountRequest request) {
        return null;
    }
}
