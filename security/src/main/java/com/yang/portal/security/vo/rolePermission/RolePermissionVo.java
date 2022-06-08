package com.yang.portal.security.vo.rolePermission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "角色权限删除")
public class RolePermissionVo {

    @ApiModelProperty("角色ID")
    @NotNull(message = "角色ID不能为空")
    @Min(1)
    private Long roleId;

    @ApiModelProperty("权限ID")
    @NotNull(message = "权限ID不能为空")
    @Min(1)
    private Long permissionId;
}
