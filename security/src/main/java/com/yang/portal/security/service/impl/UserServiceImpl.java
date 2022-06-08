package com.yang.portal.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yang.portal.core.CoreConstant;
import com.yang.portal.core.utils.PagedList;
import com.yang.portal.core.utils.Pagination;
import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.entity.User;
import com.yang.portal.security.mapper.UserMapper;
import com.yang.portal.security.service.UserService;
import com.yang.portal.security.utils.SaltUtil;
import com.yang.portal.security.vo.user.RegisterVo;
import com.yang.portal.security.vo.user.UserLockVo;
import com.yang.portal.security.vo.user.UserUpdateVo;
import com.yang.portal.security.vo.user.UserVo;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@Service
public class UserServiceImpl implements UserService {

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

    @Override
    public PagedList<User> getUsers(UserVo userVo) {
        Pagination pagination = userVo.getPagination();
        List<User> users = userMapper.getUsers(userVo, pagination.getOffset(), pagination.getPageSize(), pagination.getOrderBy());
        Long usersCount = userMapper.getUsersCount(userVo);
        return PagedList.<User>builder()
                .count(usersCount)
                .result(users)
                .pageSize(pagination.getPageSize())
                .pageNum(pagination.getPageNum())
                .build();
    }

    @Override
    public void update(UserUpdateVo userUpdateVo, Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, id)
                .eq(User::getIsDelete, CoreConstant.IS_DELETE)
                .set(User::getName, userUpdateVo.getName())
                .set(User::getPhone, userUpdateVo.getPhone())
                .set(User::getNickname, userUpdateVo.getNickname())
                .set(User::getGender, userUpdateVo.getGender())
                .set(User::getBirthday, userUpdateVo.getBirthday())
                .set(User::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(User::getUpdatedId, jwtToken.getUserPrincipal().getUserId());
        userMapper.update(lambdaUpdateWrapper);
    }

    @Override
    public void lock(UserLockVo lockVo, Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, id)
                .eq(User::getIsDelete, CoreConstant.IS_DELETE)
                .set(User::getIsLocked, lockVo.getIsLocked())
                .set(User::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(User::getUpdatedId, jwtToken.getUserPrincipal().getUserId());
        userMapper.update(lambdaUpdateWrapper);
    }

    @Override
    public void delete(Long id, JWTToken jwtToken) {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, id)
                .eq(User::getIsDelete, CoreConstant.IS_DELETE)
                .set(User::getIsDelete, !CoreConstant.IS_DELETE)
                .set(User::getUpdatedBy, jwtToken.getUserPrincipal().getNickName())
                .set(User::getUpdatedId, jwtToken.getUserPrincipal().getUserId());
        userMapper.update(lambdaUpdateWrapper);
    }
}

