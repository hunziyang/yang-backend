package com.yang.portal.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements ResultCodeBase {

    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    VALID_ERROR(505, "Method Argument Not Valid"),
    ORDER_BY_ERROR(700, "ORDER BY 格式问题,列与值必须用:分割");


    private Integer code;
    private String msg;
}
