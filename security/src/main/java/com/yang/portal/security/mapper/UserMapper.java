package com.yang.portal.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.portal.security.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(User)表数据库访问层
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
public interface UserMapper extends BaseMapper<User> {

    User getOneByUsernameAndIsDelete(@Param("username") String username, @Param("isDelete") Boolean isdelete);

}

