package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色权限(RolePermission)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("ROLE_PERMISSION")
@Accessors(chain = true)
public class RolePermission extends BaseEntity {

    //角色ID
    private Long roleId;
    //权限ID
    private Long permissionId;

    private Long uniqueId;
}

