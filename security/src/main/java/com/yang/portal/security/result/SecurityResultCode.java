package com.yang.portal.security.result;

import com.yang.portal.core.result.ResultCodeBase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SecurityResultCode implements ResultCodeBase {

    AUTHENTICATION_ERROR(20000, "认证错误"),
    USER_NOT_EXISTS(20001, "用户不存在"),
    USER_LOCKED(20002, "用户锁定"),
    USER_BAD_CREDENTIALS(20003, "密码错误"),
    ACCESS_DENIED(20004, "无权限访问");

    private Integer Code;
    private String msg;
}
