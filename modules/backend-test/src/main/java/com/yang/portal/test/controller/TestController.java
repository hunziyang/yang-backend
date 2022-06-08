package com.yang.portal.test.controller;


import com.yang.portal.core.annotation.YangController;
import com.yang.portal.core.result.Result;
import com.yang.portal.test.mapper.StudentMapper;
import com.yang.portal.test.mapper.TestMapper;
import com.yang.portal.test.vo.TestVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * (Test)表控制层
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:14
 */
@YangController("/test")
@Api("Test")
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/security")
    public Result se(TestVo testVo) {
        return Result.success(testVo);
    }
}

