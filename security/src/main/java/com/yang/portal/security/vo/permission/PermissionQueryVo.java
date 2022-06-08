package com.yang.portal.security.vo.permission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "权限查询")
public class PermissionQueryVo {

    @ApiModelProperty("权限分类ID")
    private Long permissionClassificationId;
}
