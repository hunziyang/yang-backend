package com.yang.portal.test.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.test.entity.Test;
import com.yang.portal.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@YangController("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TestMapper testMapper;

    @GetMapping
    public void insert(){
        Test test = testMapper.selectById(1L);
        redisTemplate.opsForValue().set("yang-test",test);
    }
}
