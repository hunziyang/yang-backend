package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.utils.PagedList;
import com.yang.portal.core.utils.Pagination;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.Role;
import com.yang.portal.security.mapper.RoleMapper;
import com.yang.portal.security.service.RoleService;
import com.yang.portal.security.vo.role.RoleCreateVo;
import com.yang.portal.security.vo.role.RoleQueryVo;
import com.yang.portal.security.vo.role.RoleUpdateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void createRole(RoleCreateVo roleCreateVo, JWTToken jwtToken) {
        Role role = new Role();
        BeanUtils.copyProperties(roleCreateVo, role);
        role.setCreatedId(jwtToken.getUserPrincipal().getUserId())
                .setCreatedBy(jwtToken.getUserPrincipal().getNickName());
        roleMapper.insert(role);
    }

    @Override
    public PagedList<Role> getRoles(RoleQueryVo roleQueryVo) {
        Pagination pagination = roleQueryVo.getPagination();
        List<Role> roles = roleMapper.getRoles(roleQueryVo, pagination.getOffset(), pagination.getPageSize(),pagination.getOrderBy());
        Long rolesCount = roleMapper.getRolesCount(roleQueryVo);
       return PagedList.<Role>builder()
                .pageNum(pagination.getPageNum())
                .pageSize(pagination.getPageSize())
                .result(roles)
                .count(rolesCount)
                .build();
    }

    @Override
    public void deleteRole(Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Role::getId, id)
                .eq(Role::getIsDelete, CoreConstant.IS_DELETE)
                .set(Role::getIsDelete, !CoreConstant.IS_DELETE)
                .set(Role::getUniqueId, id)
                .set(Role::getUpdatedId, jwtToken.getUserPrincipal().getUserId())
                .set(Role::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(Role::getUpdatedTime, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
        roleMapper.update(updateWrapper);
    }

    @Override
    public void updateRole(RoleUpdateVo roleUpdateVo, Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<Role> roleLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.eq(Role::getId, id)
                .eq(Role::getIsDelete, CoreConstant.IS_DELETE)
                .set(Role::getName, roleUpdateVo.getRoleName())
                .set(Role::getDescription, roleUpdateVo.getRoleDescription())
                .set(Role::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(Role::getUpdatedId, jwtToken.getUserPrincipal().getUserId())
                .set(Role::getUpdatedTime, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
        roleMapper.update(roleLambdaUpdateWrapper);
    }
}
