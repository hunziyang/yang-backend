package com.yang.portal.security.service;

import com.yang.portal.core.utils.PagedList;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.impl.userRole.UserRoleResponse;
import com.yang.portal.security.vo.userRole.UserRoleQueryVo;
import com.yang.portal.security.vo.userRole.UserRoleVo;

public interface UserRoleService {

    PagedList<UserRoleResponse> getUserRoles(UserRoleQueryVo userRoleQueryVo);
    void insertUserRole(UserRoleVo userRoleVo, JWTToken jwtToken);

    void deleteUserRole(Long id, JWTToken jwtToken);

    void deleteUserRoleByRoleId(Long roleId, JWTToken jwtToken);
}
