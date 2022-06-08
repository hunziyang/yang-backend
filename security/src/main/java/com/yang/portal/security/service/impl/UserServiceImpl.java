package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.portal.security.mapper.UserMapper;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

