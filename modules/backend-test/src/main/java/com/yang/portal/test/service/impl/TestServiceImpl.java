package com.yang.portal.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.portal.test.mapper.TestMapper;
import com.yang.portal.test.entity.Test;
import com.yang.portal.test.service.TestService;
import com.yang.portal.test.vo.TestQueryVo;
import com.yang.portal.test.vo.TestVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Test)表服务实现类
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:21
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public void createTest(Test test) {
        testMapper.insert(test);
    }

    @Override
    public void deleteTest(Long id) {
        testMapper.deleteById(id);
    }

    @Override
    public void upsertTest(Long id, TestQueryVo testQueryVo) {
        Test test = new Test();
        BeanUtils.copyProperties(testQueryVo,test);
        test.setId(id);
        testMapper.updateById(test);
    }

    @Override
    public PageInfo<Test> getTests(TestVo testVo) {
        LambdaQueryWrapper<Test> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(testVo.getName())){
            lambdaQueryWrapper.eq(Test::getName,testVo.getName());
        }
        PageHelper.startPage(testVo.getPagination().getPageNum(),testVo.getPagination().getPageSize());
        List<Test> testList = testMapper.selectList(lambdaQueryWrapper);
        PageInfo<Test> pageInfo = new PageInfo<>(testList);
        return pageInfo;
    }


}

