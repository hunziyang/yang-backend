package com.yang.portal.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * (Test)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:17
 */
@Data
@TableName("TEST")
public class Test {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "name 不能为空")
    private String name;

}

