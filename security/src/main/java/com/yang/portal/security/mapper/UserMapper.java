package com.yang.portal.security.mapper;

import com.yang.portal.core.mybatis.YangMapper;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.vo.user.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
public interface UserMapper extends YangMapper<User> {

    User getUserByUsername(@Param("username") String username);

    List<User> getUsers(@Param("query")UserVo userVo,@Param("offSet") Integer offset,@Param("rows") Integer rows,@Param("orderBy") String orderBy);
    Long getUsersCount(@Param("query")UserVo userVo);
}

