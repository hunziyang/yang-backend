package com.yang.portal.security.vo.userRole;

import com.yang.portal.core.utils.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户角色查询")
public class UserRoleQueryVo {

    @ApiModelProperty("用户 ID")
    private Long userId;

    @ApiModelProperty("角色 ID")
    private Long roleId;

    private Pagination pagination = new Pagination();
}
