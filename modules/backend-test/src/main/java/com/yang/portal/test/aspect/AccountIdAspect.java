package com.yang.portal.test.aspect;

import com.yang.portal.test.TestProperties;
import com.yang.portal.test.config.ThreadContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountIdAspect {

    @Autowired
    private TestProperties testProperties;

    @Pointcut("@annotation(com.yang.portal.test.annotation.AccountId)")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void accountIdBefore(){
        System.out.println(testProperties);
        ThreadContext.setAccountId(testProperties.getAccountId());
    }
}
