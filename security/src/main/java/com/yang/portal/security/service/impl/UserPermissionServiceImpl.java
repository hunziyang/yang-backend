package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.utils.PagedList;
import com.yang.portal.core.utils.Pagination;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.entity.UserPermission;
import com.yang.portal.security.mapper.UserMapper;
import com.yang.portal.security.mapper.UserPermissionMapper;
import com.yang.portal.security.service.UserPermissionService;
import com.yang.portal.security.service.impl.userPermission.UserPermissionResponse;
import com.yang.portal.security.vo.userPermission.GetPermissionVo;
import com.yang.portal.security.vo.userPermission.GetUserVo;
import com.yang.portal.security.vo.userPermission.UserPermissionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUserPermission(UserPermissionVo userPermissionVo, JWTToken jwtToken) {
        UserPermission userPermission = new UserPermission();
        BeanUtils.copyProperties(userPermissionVo, userPermission);
        userPermission.setCreatedBy(jwtToken.getUserPrincipal().getNickName())
                .setCreatedId(jwtToken.getUserPrincipal().getUserId());
        userPermissionMapper.insert(userPermission);

    }

    @Override
    public PagedList<UserPermissionResponse> getUserPermissions(GetPermissionVo getPermissionVo) {
        Pagination pagination = getPermissionVo.getPagination();
        List<UserPermissionResponse> userPermission = userPermissionMapper.getUserPermission(getPermissionVo, pagination.getOffset(), pagination.getPageSize(), pagination.getOrderBy());
        Long userPermissionCount = userPermissionMapper.getUserPermissionCount(getPermissionVo);
        return PagedList.<UserPermissionResponse>builder()
                .count(userPermissionCount)
                .result(userPermission)
                .pageSize(pagination.getPageSize())
                .pageNum(pagination.getPageNum())
                .build();
    }

    @Override
    public void delete(Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<UserPermission> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(UserPermission::getId, id)
                .eq(UserPermission::getIsDelete, CoreConstant.IS_DELETE)
                .set(UserPermission::getUniqueId, id)
                .set(UserPermission::getUpdatedId, jwtToken.getUserPrincipal().getUserId())
                .set(UserPermission::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(UserPermission::getUpdatedTime, ZonedDateTime.now(ZoneId.of(CoreConstant.SERVER_ZONE)))
                .set(UserPermission::getIsDelete, !CoreConstant.IS_DELETE);
        userPermissionMapper.update(lambdaUpdateWrapper);
    }
}
