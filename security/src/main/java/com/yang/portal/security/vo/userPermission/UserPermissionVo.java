package com.yang.portal.security.vo.userPermission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "用户权限")
public class UserPermissionVo {

    @NotNull
    @ApiModelProperty("用户ID")
    private Long userId;
    @NotNull
    @ApiModelProperty("权限ID")
    private Long permissionId;
}
