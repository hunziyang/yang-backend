package com.yang.portal.security.controller;


import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.UserService;
import com.yang.portal.security.vo.user.RegisterVo;
import com.yang.portal.security.vo.user.UserLockVo;
import com.yang.portal.security.vo.user.UserUpdateVo;
import com.yang.portal.security.vo.user.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(User)表控制层
 *
 * @author Tommy.Wang
 * @since 2022-07-05 23:17:02
 */
@YangController("/user")
@Api("用户操作")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Result register(@Validated @RequestBody RegisterVo registerVo) {
        userService.register(registerVo);
        return Result.success();
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("/get")
    @PreAuthorize("hasPermission('user','select')")
    public Result get(@Validated UserVo userVo) {
        return Result.success(userService.getUsers(userVo));
    }

    @ApiOperation(value = "更新用户用户")
    @PutMapping("/{id}/update")
    @PreAuthorize("hasPermission('user','update')")
    public Result update(@Validated @RequestBody UserUpdateVo userUpdateVo, @PathVariable("id") Long id, JWTToken jwtToken) {
        userService.update(userUpdateVo, id, jwtToken);
        return Result.success();
    }

    @ApiOperation("修改用户锁状态")
    @PutMapping("/{id}/lock")
    @PreAuthorize("hasPermission('user','lock')")
    public Result lock(@RequestBody @Validated UserLockVo lockVo, @PathVariable("id") Long id, JWTToken jwtToken) {
        userService.lock(lockVo, id, jwtToken);
        return Result.success();
    }

    @ApiOperation("注销用户")
    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasPermission('user','delete')")
    public Result delete(@PathVariable("id") Long id, JWTToken jwtToken) {
        userService.delete(id, jwtToken);
        return Result.success();
    }
}

