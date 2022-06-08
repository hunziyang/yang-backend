package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.UserPermissionService;
import com.yang.portal.security.vo.userPermission.GetPermissionVo;
import com.yang.portal.security.vo.userPermission.UserPermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@YangController("/userPermission")
@Api("用户权限")
public class UserPermissionController {

    @Autowired
    private UserPermissionService userPermissionService;


    @PostMapping("/create")
    @PreAuthorize("hasPermission('userPermission','insert')")
    @ApiOperation("创建用户权限")
    public Result insertUserPermission(@RequestBody @Validated UserPermissionVo userPermissionVo, JWTToken jwtToken) {
        userPermissionService.insertUserPermission(userPermissionVo, jwtToken);
        return Result.success();
    }

    @GetMapping("/getPermission")
    @ApiOperation("获取用户权限")
    @PreAuthorize("hasPermission('userPermission','select')")
    public Result getPermissions(GetPermissionVo getPermissionVo) {
        return Result.success(userPermissionService.getUserPermissions(getPermissionVo));
    }

    @DeleteMapping("/{id}/delete")
    @ApiOperation("删除用户权限")
    @PreAuthorize("hasPermission('userPermission','delete')")
    public Result delete(@PathVariable("id") Long id, JWTToken jwtToken) {
        userPermissionService.delete(id, jwtToken);
        return Result.success();
    }

}
