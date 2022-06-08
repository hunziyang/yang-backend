package com.yang.portal.security.service;

import com.yang.portal.core.utils.PagedList;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.impl.userPermission.UserPermissionResponse;
import com.yang.portal.security.vo.userPermission.GetPermissionVo;
import com.yang.portal.security.vo.userPermission.UserPermissionVo;

public interface UserPermissionService {

    void insertUserPermission(UserPermissionVo userPermissionVo, JWTToken jwtToken);

    PagedList<UserPermissionResponse> getUserPermissions(GetPermissionVo getPermissionVo);

    void delete(Long id, JWTToken jwtToken);
}
