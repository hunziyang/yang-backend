package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.RolePermissionService;
import com.yang.portal.security.vo.rolePermission.RolePermissionQueryVo;
import com.yang.portal.security.vo.rolePermission.RolePermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@YangController("/rolePermission")
@Api("角色权限")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @ApiOperation("获取角色对应权限")
    @PreAuthorize("hasPermission('rolePermission','select')")
    @GetMapping("/get")
    public Result getRolePermission(RolePermissionQueryVo rolePermissionQueryVo) {
        return Result.success(rolePermissionService.getPermissionsByRoleId(rolePermissionQueryVo.getRoleId()));
    }

    @ApiOperation("删除角色对应权限")
    @PreAuthorize("hasPermission('rolePermission','delete')")
    @DeleteMapping("/delete/{id}")
    public Result deleteRolePermission(@PathVariable("id") Long id, JWTToken jwtToken) {
        rolePermissionService.deleteRolePermission(id, jwtToken);
        return Result.success();
    }

    @ApiOperation("增加角色对应权限")
    @PreAuthorize("hasPermission('rolePermission','insert')")
    @PostMapping("/insert")
    public Result insertRolePermission(@Validated @RequestBody RolePermissionVo rolePermissionVo, JWTToken jwtToken) {
        rolePermissionService.insertRolePermission(rolePermissionVo, jwtToken);
        return Result.success();
    }
}
