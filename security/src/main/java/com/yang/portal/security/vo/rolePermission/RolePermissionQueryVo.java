package com.yang.portal.security.vo.rolePermission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "角色权限查询")
@Data
public class RolePermissionQueryVo {

    @ApiModelProperty("角色ID")
    private Long roleId;
}
