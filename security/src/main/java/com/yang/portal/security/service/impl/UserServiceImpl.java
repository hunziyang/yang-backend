package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.mapper.UserMapper;
import com.yang.portal.security.service.UserService;
import com.yang.portal.security.utils.SaltUtil;
import com.yang.portal.security.vo.RegisterVo;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * 用户表(User)表服务实现类
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(RegisterVo registerVo) {
        String salt = SaltUtil.getSalt();
        String password = Md5Crypt.md5Crypt(
                registerVo.getPassword().getBytes(StandardCharsets.UTF_8),
                String.format("%s%s", SecurityConstant.Salt.MD5_PREFIX, salt), SecurityConstant.Salt.MD5_PREFIX);
        User user = new User();
        BeanUtils.copyProperties(registerVo, user);
        user.setSalt(salt);
        user.setPassword(password);
        userMapper.insert(user);
    }
}

