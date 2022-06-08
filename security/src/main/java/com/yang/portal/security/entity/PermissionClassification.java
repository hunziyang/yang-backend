package com.yang.portal.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yang.portal.core.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName("PERMISSION_CLASSIFICATION")
@Accessors(chain = true)
@Data
public class PermissionClassification extends BaseEntity {

    //名称
    private String name;
}
