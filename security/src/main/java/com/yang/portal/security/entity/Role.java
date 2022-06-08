package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色(Rolr)表实体类
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:27:02
 */
@Data
@TableName("ROLE")
@Accessors(chain = true)
public class Role extends BaseEntity {

    //角色名
    private String name;
    //角色编码
    private String code;

    private Long uniqueId;

}

