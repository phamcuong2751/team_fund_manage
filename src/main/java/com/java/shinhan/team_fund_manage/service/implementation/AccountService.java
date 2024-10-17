package com.java.shinhan.team_fund_manage.service.implementation;

import com.java.shinhan.team_fund_manage.constaints.AccountStatus;
import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.entity.AccountEntity;
import com.java.shinhan.team_fund_manage.mapper.AccountMapper;
import com.java.shinhan.team_fund_manage.payload.request.accountRequest.AddAccountRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.payload.response.accountResponse.GetAccountListResponse;
import com.java.shinhan.team_fund_manage.repository.AccountRepository;
import com.java.shinhan.team_fund_manage.repository.MemberRepository;
import com.java.shinhan.team_fund_manage.service.IAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;

    public AccountService(AccountRepository accountRepository, MemberRepository memberRepository) {
        this.accountRepository = accountRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public BaseResponse getAllAccount() {
        List<AccountEntity> allAccount = accountRepository.findAll();
        List<GetAccountListResponse> responses = allAccount.stream().filter(account -> !AccountStatus.DELETED.status.equals(account.getStatus())).map(account -> {
            GetAccountListResponse response = AccountMapper.INSTANCE.getAllEntityToResponse(account);
            response.setStatus(AccountStatus.fromStatus(response.getStatus()));
            return response;
        }).collect(Collectors.toList());
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.GET_SUCCESS.getMessage(), responses);
    }

    @Override
    public BaseResponse getAccount(String accountNo) {
        return null;
    }

    @Override
    public BaseResponse insert(AddAccountRequest request) {
        AccountEntity entity = AccountMapper.INSTANCE.getRequestToEntity(request);

        //Check existing account
        if (accountRepository.existsByAccountNoAndBankCode(request.getAccountNo(), request.getBankCode())) {
            return BaseResponseBuilder.build(HttpStatusCode.BAD_REQUEST.code, ApiLabel.ACCOUNT_EXISTING.getMessage());
        }

        //Check account already use by any user yet
        if (accountRepository.existsByAccountNoAndMember_Id(request.getAccountNo(), request.getMemberId())) {
            return BaseResponseBuilder.build(HttpStatusCode.BAD_REQUEST.code, ApiLabel.ACCOUNT_ALREADY_USE.getMessage());
        }

        //Check existing user
        memberRepository.findById(request.getMemberId()).orElseThrow(() -> new IllegalArgumentException(ApiLabel.MEM_NOT_FOUND.getMessage()));

        accountRepository.save(entity);
        return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.INSERT_SUCCESS.getMessage());
    }

    @Override
    public BaseResponse delete(String accountNo) {
        Optional<AccountEntity> accountOptional = accountRepository.findByAccountNo(accountNo);
        if (accountOptional.isPresent()) {
            AccountEntity account = accountOptional.get();
            account.setStatus(AccountStatus.DELETED.status);
            account.setUpdateAt(LocalDateTime.now());
            accountRepository.save(account);
            return BaseResponseBuilder.build(HttpStatusCode.OK.code, ApiLabel.DELETE_SUCCESS.getMessage());
        } else {
            return BaseResponseBuilder.build(HttpStatusCode.BAD_REQUEST.code, ApiLabel.ACCOUNT_NOT_FOUND.getMessage());
        }
    }
}
