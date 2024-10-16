package com.java.shinhan.team_fund_manage.controller;

import com.java.shinhan.team_fund_manage.constaints.HttpStatusCode;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.AddMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.DeleteMemberRequest;
import com.java.shinhan.team_fund_manage.payload.request.memberRequest.UpdateMemberRequest;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import com.java.shinhan.team_fund_manage.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> getAllMember() {
        try {
            BaseResponse response = memberService.getAllMember();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> getMemberByName(@RequestParam(value = "name") String name) {
        try {
            BaseResponse response = memberService.getMemberByName(name);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> addMember(@RequestBody AddMemberRequest request) {
        try {
            BaseResponse response = memberService.addMember(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<BaseResponse> updateMember(@RequestBody UpdateMemberRequest request) {
        try {
            BaseResponse response = memberService.updateMember(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<BaseResponse> deleteMember(@RequestBody DeleteMemberRequest request) {
        try {
            BaseResponse response = memberService.deleteMember(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatusCode.INTERNAL_SERVER_ERROR.code, e.getMessage()), HttpStatus.OK);
        }

    }
}
