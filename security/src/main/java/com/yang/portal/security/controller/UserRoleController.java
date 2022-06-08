package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.UserRoleService;
import com.yang.portal.security.vo.userRole.UserRoleQueryVo;
import com.yang.portal.security.vo.userRole.UserRoleVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@YangController("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation("获取用户角色")
    @PreAuthorize("hasPermission('userRole','select')")
    @GetMapping("/get")
    public Result getUserRoles(UserRoleQueryVo userRoleQueryVo) {
        return Result.success(userRoleService.getUserRoles(userRoleQueryVo));
    }

    @ApiOperation("增加用户角色")
    @PreAuthorize("hasPermission('userRole','insert')")
    @PostMapping("/insert")
    public Result insertUserRole(@RequestBody @Validated UserRoleVo userRoleVo, JWTToken jwtToken) {
        userRoleService.insertUserRole(userRoleVo, jwtToken);
        return Result.success();
    }

    @ApiOperation("删除用户角色")
    @PreAuthorize("hasPermission('userRole','delete')")
    @DeleteMapping("/{id}/delete")
    public Result deleteUserRole(@PathVariable("id") Long id, JWTToken jwtToken) {
        userRoleService.deleteUserRole(id, jwtToken);
        return Result.success();
    }

}
