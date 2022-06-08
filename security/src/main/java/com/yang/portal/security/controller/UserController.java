package com.yang.portal.security.controller;


import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.service.UserService;
import com.yang.portal.security.vo.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}

