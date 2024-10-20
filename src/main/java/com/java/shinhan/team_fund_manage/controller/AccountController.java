package com.java.shinhan.team_fund_manage.controller;

import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.payload.request.accountRequest.AddAccountRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.service.implementation.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> getAllAccount() {
        try {
            BaseResponse response = accountService.getAllAccount();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> addAccount(@RequestBody AddAccountRequest request) {
        try {
            BaseResponse response = accountService.insert(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{accountNo}", method = RequestMethod.DELETE)
    public ResponseEntity<BaseResponse> deleteAccount(@PathVariable String accountNo) {
        try {
            BaseResponse response = accountService.delete(accountNo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }
    }
}
