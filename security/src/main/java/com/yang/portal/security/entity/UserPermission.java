package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户权限(UserPermission)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("USER_PERMISSION")
@Accessors(chain = true)
public class UserPermission extends BaseEntity {

    //用户主键
    private Long userId;
    //权限主键
    private Long permissionId;
    private Long uniqueId;

}

