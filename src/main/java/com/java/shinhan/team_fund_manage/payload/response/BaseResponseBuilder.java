package com.java.shinhan.team_fund_manage.payload.response;

public class BaseResponseBuilder {
    public static <T> BaseResponse<T> build(int statusCode, String message, T data) {
        return new BaseResponse<>(statusCode, message, data);
    }

    public static <T> BaseResponse<T> build(int statusCode, String message) {
        return new BaseResponse<>(statusCode, message);
    }
}