package com.yang.portal.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements ResultCodeBase{

    SUCCESS(200,"Success"),
    BAD_REQUEST(400,"Bad Request"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
    VALID_ERROR(505,"Method Argument Not Valid");


    private Integer code;
    private String msg;
}
