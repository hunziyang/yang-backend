package com.yang.portal.core.schedule;

import com.yang.portal.core.CoreConstant;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.TimeZone;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT1H")
@SuppressWarnings("all")
public class ShedlockConfig {


    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(JdbcTemplateLockProvider.Configuration.builder()
                .withJdbcTemplate(new JdbcTemplate(dataSource))
                .withTimeZone(TimeZone.getTimeZone("Asia/Shanghai"))
                .withTableName(CoreConstant.Shedlock.TABLE_NAME)
                .withColumnNames(new JdbcTemplateLockProvider.ColumnNames(
                        CoreConstant.Shedlock.NAME,
                        CoreConstant.Shedlock.LOCK_UNTIL,
                        CoreConstant.Shedlock.LOCKED_AT,
                        CoreConstant.Shedlock.LOCKED_BY))
                .build());
    }
}
