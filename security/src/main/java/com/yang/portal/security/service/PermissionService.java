package com.yang.portal.security.service;

import com.yang.portal.security.entity.Permission;
import com.yang.portal.security.vo.permission.PermissionQueryVo;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissions(PermissionQueryVo permissionQueryVo);
}
