package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * 用户表(User)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@Data
@TableName("USER")
@Accessors(chain = true)
public class User extends BaseEntity {

    //账号
    private String username;
    //唯一性验证
    private Long uniqueId;
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
    private Boolean isLocked;
}

