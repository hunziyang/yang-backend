package com.yang.portal.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Test)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:17
 */
@Data
@TableName("TEST")
@Accessors(chain = true)
public class Test {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;

}

