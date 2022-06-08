package com.yang.portal.core.exception;

import com.yang.portal.core.result.ResultCode;

import java.util.Map;

public class InternalServerErrorException extends BaseException{

    public InternalServerErrorException() {
        super(ResultCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(Map<String, ?> errors) {
        super(ResultCode.INTERNAL_SERVER_ERROR, errors);
    }
}
