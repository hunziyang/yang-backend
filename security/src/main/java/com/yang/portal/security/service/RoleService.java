package com.yang.portal.security.service;

import com.yang.portal.core.utils.PagedList;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.Role;
import com.yang.portal.security.vo.role.RoleCreateVo;
import com.yang.portal.security.vo.role.RoleQueryVo;
import com.yang.portal.security.vo.role.RoleUpdateVo;

public interface RoleService {

    void createRole(RoleCreateVo roleCreateVo, JWTToken jwtToken);

    PagedList<Role> getRoles(RoleQueryVo roleQueryVo);

    void deleteRole(Long id, JWTToken jwtToken);

    void updateRole(RoleUpdateVo roleUpdateVo, Long id, JWTToken jwtToken);
}
