package com.java.shinhan.team_fund_manage.controller;

import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.payload.request.trxCategoryRequest.AddTrxCategoryRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.service.implementation.TrxCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction-categories")
public class TrxCategoryController {
    private final TrxCategoryService trxCategoryService;

    public TrxCategoryController(TrxCategoryService trxCategoryService) {
        this.trxCategoryService = trxCategoryService;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> getAll() {
        try {
            BaseResponse response = trxCategoryService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> insert(@RequestBody AddTrxCategoryRequest request) {
        try {
            BaseResponse response = trxCategoryService.insert(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }
    }
}
