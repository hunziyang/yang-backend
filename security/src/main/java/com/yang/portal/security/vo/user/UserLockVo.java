package com.yang.portal.security.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLockVo {

    @NotNull(message = "isLocked 不能为空")
    private Boolean isLocked;
}
