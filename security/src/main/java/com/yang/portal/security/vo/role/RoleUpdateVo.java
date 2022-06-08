package com.yang.portal.security.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "角色更新")
public class RoleUpdateVo {

    @ApiModelProperty("角色名")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;
}
