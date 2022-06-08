package com.yang.portal.security.service.impl.userRole;

import com.yang.portal.security.entity.UserRole;
import lombok.Data;

@Data
public class UserRoleResponse extends UserRole {

    private String nickName;
    private String userName;
    private String roleName;
}
