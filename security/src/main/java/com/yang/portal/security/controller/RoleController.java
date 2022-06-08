package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.security.service.RolePermissionService;
import com.yang.portal.security.service.RoleService;
import com.yang.portal.security.service.UserRoleService;
import com.yang.portal.security.vo.role.RoleCreateVo;
import com.yang.portal.security.vo.role.RoleQueryVo;
import com.yang.portal.security.vo.role.RoleUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@YangController("/role")
@Api("角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/create")
    @PreAuthorize("hasPermission('role','insert')")
    @ApiOperation("创建角色")
    public Result createRole(@Validated @RequestBody RoleCreateVo roleCreateVo, @ApiIgnore JWTToken jwtToken) {
        roleService.createRole(roleCreateVo, jwtToken);
        return Result.success();
    }

    @GetMapping("/get")
    @PreAuthorize("hasPermission('role','select')")
    @ApiOperation("获取角色")
    public Result getRoles(RoleQueryVo roleQueryVo) {
        return Result.success(roleService.getRoles(roleQueryVo));
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasPermission('role','update')")
    public Result updateRole(@RequestBody RoleUpdateVo roleUpdateVo, @PathVariable("id") Long id, JWTToken jwtToken) {
        roleService.updateRole(roleUpdateVo, id, jwtToken);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasPermission('role','delete')")
    @ApiOperation("删除角色")
    public Result deleteRole(@ApiParam(required = true, value = "角色 ID") @PathVariable("id") Long id, @ApiIgnore JWTToken jwtToken) {
        roleService.deleteRole(id, jwtToken);
        userRoleService.deleteUserRoleByRoleId(id, jwtToken);
        rolePermissionService.deleteRolePermissionByRoleId(id, jwtToken);
        return Result.success();
    }
}
