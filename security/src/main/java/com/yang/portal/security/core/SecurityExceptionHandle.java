package com.yang.portal.security.core;

import com.yang.portal.core.result.Result;
import com.yang.portal.security.result.SecurityResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class SecurityExceptionHandle {

    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDeniedException(AccessDeniedException accessDeniedException){
        return Result.error(SecurityResultCode.ACCESS_DENIED);
    }

}
