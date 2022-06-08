package com.yang.portal.core.exception;

import com.yang.portal.core.result.ResultCodeBase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@AllArgsConstructor
@Data
public class BaseException extends RuntimeException{

    private ResultCodeBase resultCodeBase;
    private Map<String,?> errors;

    public BaseException(ResultCodeBase resultCodeBase){
        this.resultCodeBase = resultCodeBase;
    }


}
