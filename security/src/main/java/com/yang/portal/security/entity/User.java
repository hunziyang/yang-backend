package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户表(User)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@Data
@TableName("USER")
public class User {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //账号
    private String username;
    //密码
    private String password;
    //盐值
    private String salt;
    //姓名
    private String name;
    //手机号
    private String phone;
    //昵称
    private String nickname;
    //性别
    private Integer gender;
    //生日
    private LocalDate birthday;
    //是否锁定
    private Integer islocked;
    //描述
    private String description;
    //是否删除
    private Integer isdelete;
    //乐观锁
    @Version
    private Integer revision;
    //创建人
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private String createdBy;
    //创建时间
    private LocalDateTime createdTime;
    //更新人
    private String updatedBy;
    //更新时间
    @TableField(value = "UPDATED_TIME", fill = FieldFill.UPDATE)
    private LocalDateTime updatedTime;

}

