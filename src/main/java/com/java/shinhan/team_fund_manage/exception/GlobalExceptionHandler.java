package com.java.shinhan.team_fund_manage.exception;

import com.java.shinhan.team_fund_manage.constaints.ApiLabel;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponse;
import com.java.shinhan.team_fund_manage.payload.response.BaseResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(BaseResponseBuilder.build(HttpStatus.BAD_REQUEST.value(), ApiLabel.VALIDATION_FAIL.text, errors), HttpStatus.BAD_REQUEST);
    }
}
