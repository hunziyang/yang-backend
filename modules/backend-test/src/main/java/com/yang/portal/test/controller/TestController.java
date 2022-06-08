package com.yang.portal.test.controller;


import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.security.core.jwt.JWTToken;
import com.yang.portal.test.entity.Test;
import com.yang.portal.test.service.TestService;
import com.yang.portal.test.vo.TestQueryVo;
import com.yang.portal.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * (Test)表控制层
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:14
 */
@YangController("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/create")
    public Result createTest(@RequestBody @Validated Test test) {
        testService.createTest(test);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteTest(@PathVariable("id") Long id) {
        testService.deleteTest(id);
        return Result.success();
    }

    @PatchMapping("/upsert/{id}")
    public Result upsertTest(@PathVariable("id") Long id, @RequestBody TestQueryVo testQueryVo) {
        testService.upsertTest(id, testQueryVo);
        return Result.success();
    }

    @GetMapping("/get")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasPermission('role','insert')")
    public Result getTests(TestVo testVo, Principal principal){
        JWTToken jwtToken = (JWTToken) principal;
        return Result.success(testService.getTests(testVo));
    }

}

