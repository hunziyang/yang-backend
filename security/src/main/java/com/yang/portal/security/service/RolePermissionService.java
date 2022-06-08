package com.yang.portal.security.service;

import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.Permission;
import com.yang.portal.security.vo.rolePermission.RolePermissionVo;

import java.util.List;

public interface RolePermissionService {

    List<Permission> getPermissionsByRoleId(Long roleId);

    void deleteRolePermission(Long id, JWTToken jwtToken);

    void insertRolePermission(RolePermissionVo rolePermissionVo, JWTToken jwtToken);

    void deleteRolePermissionByRoleId(Long roleId, JWTToken jwtToken);
}
