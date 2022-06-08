package com.yang.portal.security.vo.role;

import com.yang.portal.core.utils.Pagination;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色查询")
public class RoleQueryVo{

    @ApiModelProperty("角色名称")
    private String roleName;
    @ApiModelProperty("角色编码")
    private String roleCode;
    @ApiModelProperty("角色描述")
    private String description;
    @ApiModelProperty("分页")
    private Pagination pagination = new Pagination();
}
