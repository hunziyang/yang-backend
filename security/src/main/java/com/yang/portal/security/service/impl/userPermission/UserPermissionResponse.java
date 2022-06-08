package com.yang.portal.security.service.impl.userPermission;

import com.yang.portal.security.entity.UserPermission;
import lombok.Data;

@Data
public class UserPermissionResponse extends UserPermission {

    private String userName;
    private String permissionName;
    private String nickName;
}
