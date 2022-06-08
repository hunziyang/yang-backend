package com.yang.portal.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.portal.security.entity.Permission;

import java.util.List;

/**
 * 权限(Permission)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getAllByUserIdAndIsDelete(Long userId, Boolean isDelete);
}
