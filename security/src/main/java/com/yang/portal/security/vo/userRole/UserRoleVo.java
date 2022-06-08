package com.yang.portal.security.vo.userRole;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserRoleVo {

    @NotNull(message = "userId 不能为空")
    @Min(1)
    private Long userId;

    @NotNull(message = "roleId 不能为空")
    @Min(1)
    private Long roleId;
}
