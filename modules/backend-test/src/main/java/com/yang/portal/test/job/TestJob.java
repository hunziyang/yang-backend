package com.yang.portal.test.job;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Profile("prod")
public class TestJob {


    @SchedulerLock(name = "yang-test", lockAtMostFor = "PT1H")
    @Scheduled(cron = "0/15 * * * * ?")
    public void test() {
        log.warn("now:{}", System.currentTimeMillis());
        throw new RuntimeException("test");
    }
}
