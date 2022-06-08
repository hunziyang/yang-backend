package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.utils.PagedList;
import com.yang.portal.core.utils.Pagination;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.UserRole;
import com.yang.portal.security.mapper.UserRoleMapper;
import com.yang.portal.security.service.UserRoleService;
import com.yang.portal.security.service.impl.userRole.UserRoleResponse;
import com.yang.portal.security.vo.userRole.UserRoleQueryVo;
import com.yang.portal.security.vo.userRole.UserRoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public PagedList<UserRoleResponse> getUserRoles(UserRoleQueryVo userRoleQueryVo) {
        Pagination pagination = userRoleQueryVo.getPagination();
        List<UserRoleResponse> userRoles = userRoleMapper.getUserRoles(userRoleQueryVo, pagination.getOffset(), pagination.getPageSize(), pagination.getOrderBy());
        Long userRolesCount = userRoleMapper.getUserRolesCount(userRoleQueryVo);
        return PagedList.<UserRoleResponse>builder()
                .count(userRolesCount)
                .result(userRoles)
                .pageNum(pagination.getPageNum())
                .pageSize(pagination.getPageSize())
                .build();
    }

    @Override
    public void insertUserRole(UserRoleVo userRoleVo, JWTToken jwtToken) {
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(userRoleVo, userRole);
        userRole.setCreatedId(jwtToken.getUserPrincipal().getUserId())
                .setCreatedBy(jwtToken.getUserPrincipal().getNickName());
        userRoleMapper.insert(userRole);
    }

    @Override
    public void deleteUserRole(Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<UserRole> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .eq(UserRole::getId, id)
                .eq(UserRole::getIsDelete, CoreConstant.IS_DELETE)
                .set(UserRole::getUniqueId, id)
                .set(UserRole::getIsDelete, !CoreConstant.IS_DELETE)
                .set(UserRole::getUpdatedId, jwtToken.getUserPrincipal().getUserId())
                .set(UserRole::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(UserRole::getUpdatedTime, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
        userRoleMapper.update(lambdaUpdateWrapper);
    }

    @Override
    public void deleteUserRoleByRoleId(Long roleId, JWTToken jwtToken) {
        userRoleMapper.deleteUserRoleByRoleId(roleId, jwtToken, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)));
    }
}
