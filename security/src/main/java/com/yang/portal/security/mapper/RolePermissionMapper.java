package com.yang.portal.security.mapper;

import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.time.ZonedDateTime;

/**
 * 角色权限(RolePermission)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface RolePermissionMapper extends YangMapper<RolePermission> {

    void deleteRolePermissionByRoleId(@Param("roleId") Long roleId, @Param("jwtToken") JWTToken jwtToken, @Param("time") ZonedDateTime now);
}

