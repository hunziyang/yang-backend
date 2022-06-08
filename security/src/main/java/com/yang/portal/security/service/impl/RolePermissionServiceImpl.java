package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.portal.core.CoreConstant;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.Permission;
import com.yang.portal.security.entity.RolePermission;
import com.yang.portal.security.mapper.PermissionMapper;
import com.yang.portal.security.mapper.RolePermissionMapper;
import com.yang.portal.security.service.RolePermissionService;
import com.yang.portal.security.vo.rolePermission.RolePermissionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> getPermissionsByRoleId(Long roleId) {
        return permissionMapper.getPermissionsByRoleId(roleId);
    }

    @Override
    public void deleteRolePermission(Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<RolePermission> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(RolePermission::getId, id)
                .eq(RolePermission::getIsDelete, CoreConstant.IS_DELETE)
                .set(RolePermission::getIsDelete, !CoreConstant.IS_DELETE)
                .set(RolePermission::getUniqueId, id)
                .set(RolePermission::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(RolePermission::getUpdatedId, jwtToken.getUserPrincipal().getUserId())
                .set(RolePermission::getUpdatedTime, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
        rolePermissionMapper.update(lambdaUpdateWrapper);
    }

    @Override
    public void insertRolePermission(RolePermissionVo rolePermissionVo, JWTToken jwtToken) {
        RolePermission rolePermission = new RolePermission();
        BeanUtils.copyProperties(rolePermissionVo, rolePermission);
        rolePermission.setCreatedId(jwtToken.getUserPrincipal().getUserId())
                .setCreatedBy(jwtToken.getUserPrincipal().getNickName());
        rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public void deleteRolePermissionByRoleId(Long roleId, JWTToken jwtToken) {
        rolePermissionMapper.deleteRolePermissionByRoleId(roleId, jwtToken, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
    }
}
