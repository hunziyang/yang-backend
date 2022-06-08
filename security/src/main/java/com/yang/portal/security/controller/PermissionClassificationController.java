package com.yang.portal.security.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.service.PermissionClassificationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@YangController("/permissionClassification")
public class PermissionClassificationController {

    @Autowired
    private PermissionClassificationService permissionClassificationService;

    @GetMapping("/get")
    @PreAuthorize("hasPermission('permissionClassification','select')")
    @ApiOperation("查看权限分类")
    public Result getPermissionClassification() {
        return Result.success(permissionClassificationService.getPermissionClassification());
    }
}
