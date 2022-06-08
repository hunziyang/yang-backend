package com.yang.portal.core.exception;

import com.yang.portal.core.result.ResultCodeBase;
import lombok.Data;

import java.util.Map;

@Data
public class BaseException extends RuntimeException {

    private ResultCodeBase resultCodeBase;
    private Map<String, ?> errors;

    public BaseException(ResultCodeBase resultCodeBase) {
        super(resultCodeBase.getMsg());
        this.resultCodeBase = resultCodeBase;
    }

    public BaseException(ResultCodeBase resultCodeBase, Map<String, ?> errors) {
        super(resultCodeBase.getMsg());
        this.resultCodeBase = resultCodeBase;
        this.errors = errors;
    }

}
