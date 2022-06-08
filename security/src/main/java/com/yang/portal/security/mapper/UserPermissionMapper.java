package com.yang.portal.security.mapper;


import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.entity.UserPermission;
import com.yang.portal.security.service.impl.userPermission.UserPermissionResponse;
import com.yang.portal.security.vo.userPermission.GetPermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户权限(UserPermission)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:36
 */
public interface UserPermissionMapper extends YangMapper<UserPermission> {
    List<UserPermissionResponse> getUserPermission(@Param("query") GetPermissionVo getPermissionVo, @Param("offSet") Integer offset, @Param("rows") Integer rows, @Param("orderBy") String orderBy);
    Long getUserPermissionCount(@Param("query") GetPermissionVo getPermissionVo);
}

