package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 权限(Permission)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("PERMISSION")
@Accessors(chain = true)
public class Permission extends BaseEntity {

    //名称
    private String name;
    //编码
    private String code;
    //权限分类ID
    private Long permissionClassificationId;

}

