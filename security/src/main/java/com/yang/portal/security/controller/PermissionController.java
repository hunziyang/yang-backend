package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.service.PermissionService;
import com.yang.portal.security.vo.permission.PermissionQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@YangController("/permission")
@Api("权限")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/get")
    @PreAuthorize("hasPermission('permission','select')")
    @ApiOperation("查看权限")
    public Result getPermissions(PermissionQueryVo permissionQueryVo) {
        return Result.success(permissionService.getPermissions(permissionQueryVo));
    }

}
