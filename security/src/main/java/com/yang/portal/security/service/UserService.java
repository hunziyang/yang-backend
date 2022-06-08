package com.yang.portal.security.service;

import com.yang.portal.core.utils.PagedList;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.vo.user.RegisterVo;
import com.yang.portal.security.vo.user.UserLockVo;
import com.yang.portal.security.vo.user.UserUpdateVo;
import com.yang.portal.security.vo.user.UserVo;

/**
 * 用户表(User)表服务接口
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
public interface UserService {

    void register(RegisterVo registerVo);

    PagedList<User> getUsers(UserVo userVo);

    void update(UserUpdateVo userUpdateVo, Long id, JWTToken jwtToken);

    void lock(UserLockVo lockVo, Long id, JWTToken jwtToken);

    void delete(Long id, JWTToken jwtToken);
}

