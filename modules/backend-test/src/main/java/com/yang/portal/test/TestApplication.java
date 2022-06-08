package com.yang.portal.test;

import com.yang.portal.core.annotation.YangApplication;
import com.yang.portal.core.utils.SpringUtil;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@YangApplication
@EnableAspectJAutoProxy
@EnableAsync
public class TestApplication {

    public static void main(String[] args) {
        SpringUtil.run(TestApplication.class, args);
    }
}
