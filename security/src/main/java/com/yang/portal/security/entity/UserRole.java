package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户角色(UserRole)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("USER_ROLE")
@Accessors(chain = true)
public class UserRole extends BaseEntity {

    //用户ID
    private Long userId;
    //角色ID
    private Long roleId;
    private Long uniqueId;

}

