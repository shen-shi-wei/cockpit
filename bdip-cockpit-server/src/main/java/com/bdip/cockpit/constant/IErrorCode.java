package com.bdip.cockpit.constant;

/**
 * 封装API的错误码
 * Created by zpp on 2021/3/2.
 */
public interface IErrorCode {

    int getCode();

    String getMessage();

    String getMsgKey();
}
