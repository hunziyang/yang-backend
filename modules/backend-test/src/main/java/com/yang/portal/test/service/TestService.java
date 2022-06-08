package com.yang.portal.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.portal.test.entity.Test;
import com.yang.portal.test.vo.TestQueryVo;

/**
 * (Test)表服务接口
 *
 * @author Tommy.Wang
 * @since 2022-06-16 23:29:19
 */
public interface TestService extends IService<Test> {

    void createTest(Test test);
    void deleteTest(Long id);
    void upsertTest(Long id, TestQueryVo testQueryVo);

    void sync(int i);

}

