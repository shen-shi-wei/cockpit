package com.bdip.cockpit.constant;

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private String message;
    private T data;
    private String msgKey;
    private boolean success;


    public ApiResult(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public ApiResult() {
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ApiResult(int code, String message, T data, String msgKey) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.msgKey = msgKey;

        if(EnumResultCode.SUCCESS.getCode() == code){
            this.success = true;
        }else{
            this.success = false;
        }
    }

    public static <T> ApiResult<T> error(int code, String message, String msgKey) {
        return new ApiResult<T>(code, message, null, msgKey);
    }

    public static <T> ApiResult<T> success() {
        return success(null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(EnumResultCode.SUCCESS.getCode(), EnumResultCode.SUCCESS.getMessage(), data, EnumResultCode.SUCCESS.getMsgKey());
    }

    public static <T> ApiResult<T> success(T data, String message, String msgKey) {
        return new ApiResult<T>(EnumResultCode.SUCCESS.getCode(), message, data, msgKey);
    }

    public static <T> ApiResult<T> failed() {
        return failed(EnumResultCode.FAILED);
    }

    public static <T> ApiResult<T> failed(IErrorCode errorCode) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null, errorCode.getMsgKey());
    }

    public static <T> ApiResult<T> paramError() {
        return paramError(EnumResultCode.PARAM_ERROR);
    }

    public static <T> ApiResult<T> paramError(IErrorCode errorCode) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null, errorCode.getMsgKey());
    }

    public static <T> ApiResult<T> failed(String message, String msgKey) {
        return new ApiResult<T>(EnumResultCode.FAILED.getCode(), message, null, msgKey);
    }

    public static <T> ApiResult<T> rateLimit() {
        return failed(EnumResultCode.RATE_LIMIT);
    }

    public static <T> ApiResult<T> duplicateName() {
        return failed(EnumResultCode.DUPLICATE_NAME);
    }

    public static <T> ApiResult<T> validateFailed() {
        return failed(EnumResultCode.VALIDATE_FAILED);
    }

    public static <T> ApiResult<T> validateFailed(String message, String msgKey) {
        return new ApiResult<T>(EnumResultCode.VALIDATE_FAILED.getCode(), message, null, msgKey);
    }

    public static <T> ApiResult<T> setApiResult(IErrorCode errorCode){
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null, errorCode.getMsgKey());
    }
}
