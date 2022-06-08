package com.yang.portal.security.vo.permission;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "权限分类更新")
public class PermissionUpdateVo {

    private Long permissionCId;
}
