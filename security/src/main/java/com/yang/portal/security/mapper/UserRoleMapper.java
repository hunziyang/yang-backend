package com.yang.portal.security.mapper;


import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.UserRole;
import com.yang.portal.security.service.impl.userRole.UserRoleResponse;
import com.yang.portal.security.vo.userRole.UserRoleQueryVo;
import org.apache.ibatis.annotations.Param;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 用户角色(UserRole)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface UserRoleMapper extends YangMapper<UserRole> {

    void deleteUserRoleByRoleId(@Param("roleId") Long roleId, @Param("jwtToken") JWTToken jwtToken, @Param("time") ZonedDateTime now);

    List<UserRoleResponse> getUserRoles(@Param("query") UserRoleQueryVo userRoleQueryVo, @Param("offset") Integer offset, @Param("rows") Integer pageSize, @Param("orderBy") String orderBy);
    Long getUserRolesCount(@Param("query") UserRoleQueryVo userRoleQueryVo);
}

