package com.yang.portal.test.vo;

import com.yang.portal.core.mybatis.Pagination;
import lombok.Data;

@Data
public class TestVo {

    private Pagination pagination;
    private String name;
}
