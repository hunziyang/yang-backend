package com.yang.portal.test.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class RedisVo {

    @NotBlank
    private String value;
}
