package com.yang.portal.security.mapper;

import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限(Permission)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface PermissionMapper extends YangMapper<Permission> {

    List<Permission> getPermissionsByRoleId(@Param("roleId") Long roleId);

    List<String> getPermissionCodesByUserId(@Param("userId") Long userId);
}

