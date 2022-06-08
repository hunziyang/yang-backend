package com.yang.portal.test.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestQueryVo {

    @NotBlank(message = "name 不能为空")
    private String name;
}
