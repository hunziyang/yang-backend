package com.yang.portal.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.portal.security.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色(Rolr)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-08-07 08:28:37
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getAllByUserIdAndIsDelete(@Param("userId") Long userId, @Param("isDelete") Boolean isDelete);
}

