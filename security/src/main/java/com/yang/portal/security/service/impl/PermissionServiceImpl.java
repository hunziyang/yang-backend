package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.portal.security.entity.Permission;
import com.yang.portal.security.mapper.PermissionMapper;
import com.yang.portal.security.service.PermissionService;
import com.yang.portal.security.vo.permission.PermissionQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissions(PermissionQueryVo permissionQueryVo) {
        LambdaQueryWrapper<Permission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(permissionQueryVo.getPermissionClassificationId())
                .ifPresent(permissionClassificationId -> lambdaQueryWrapper.eq(Permission::getPermissionClassificationId, permissionClassificationId));
        return permissionMapper.selectList(lambdaQueryWrapper);
    }
}
