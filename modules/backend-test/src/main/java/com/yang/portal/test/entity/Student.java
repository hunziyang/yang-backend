package com.yang.portal.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("STUDENT")
public class Student {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private Long testId;

}
