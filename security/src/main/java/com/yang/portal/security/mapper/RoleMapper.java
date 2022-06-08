package com.yang.portal.security.mapper;

import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.entity.Role;
import com.yang.portal.security.vo.role.RoleQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色(Rolr)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface RoleMapper extends YangMapper<Role> {

    List<String> getRoleCodesByUserId(@Param("userId") Long userId);

    List<Role> getRoles(@Param("query") RoleQueryVo roleQueryVo, @Param("offset") Integer offset, @Param("rows") Integer rows, @Param("orderBy") String orderBy);

    Long getRolesCount(@Param("query") RoleQueryVo roleQueryVo);
}

