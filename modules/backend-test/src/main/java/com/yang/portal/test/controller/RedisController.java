package com.yang.portal.test.controller;

import com.yang.portal.core.annotation.YangController;
import com.yang.portal.test.vo.RedisVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

@YangController("redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public long insert(@RequestParam("str") String str) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(str,redisTemplate.getConnectionFactory());
        long amount = redisAtomicLong.incrementAndGet();
        System.out.println(amount);
        if (amount == 1){
            ZonedDateTime zone = ZonedDateTime.now(ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(10).withSecond(0);
            redisAtomicLong.expireAt(zone.toInstant());
        }
        return amount;
    }

    @PostMapping
    public void update() {
        redisTemplate.expire("yang", 10L, TimeUnit.MINUTES);
    }

    @PostMapping("/zset")
    public void zset(@RequestBody RedisVo redisVo) {
        redisTemplate.opsForZSet().add("yang-zset", redisVo.getValue(), System.currentTimeMillis());
    }
}
