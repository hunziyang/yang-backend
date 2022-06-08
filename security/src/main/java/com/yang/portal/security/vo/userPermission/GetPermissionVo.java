package com.yang.portal.security.vo.userPermission;

import com.yang.portal.core.utils.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户权限-获取权限")
public class GetPermissionVo {

    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("权限ID")
    private Long permissionId;

    private Pagination pagination = new Pagination();
}
