package com.yang.portal.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.vo.RegisterVo;

/**
 * 用户表(User)表服务接口
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
public interface UserService extends IService<User> {

    void register(RegisterVo registerVo);
}

