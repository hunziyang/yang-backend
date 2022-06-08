package com.yang.portal.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.portal.test.config.ThreadContext;
import com.yang.portal.test.entity.Test;
import com.yang.portal.test.mapper.TestMapper;
import com.yang.portal.test.service.TestService;
import com.yang.portal.test.vo.TestQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
    @Async()
    public void sync(int i) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

        }
        System.out.println("test:"+i);
        System.out.println(ThreadContext.getAccountId());
    }


}

