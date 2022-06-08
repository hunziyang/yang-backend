package com.yang.portal.security.vo.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "角色注册")
public class RoleCreateVo {

    @ApiModelProperty("角色名")
    @NotBlank(message = "角色名不能为空")
    private String name;

    @ApiModelProperty("角色编码")
    @NotBlank(message = "角色编码不能为空")
    private String code;

    @ApiModelProperty("角色描述")
    private String description;

}
