package com.yang.portal.test;

import com.yang.portal.core.annotation.YangApplication;
import com.yang.portal.core.utils.SpringUtil;

@YangApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringUtil.run(TestApplication.class, args);
    }
}
