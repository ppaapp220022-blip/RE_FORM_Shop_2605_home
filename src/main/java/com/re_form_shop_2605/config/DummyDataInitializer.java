package com.re_form_shop_2605.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 홈서버 초기 배포 시점에만 더미 SQL을 선택적으로 실행한다.
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class DummyDataInitializer implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Value("${app.seed.dummy.enabled:false}")
    private boolean dummySeedEnabled;

    @Value("${app.seed.dummy.force:false}")
    private boolean dummySeedForce;

    @Override
    public void run(ApplicationArguments args) {
        if (!dummySeedEnabled) {
            log.info("[DummyDataInitializer] skip dummy seed - disabled");
            return;
        }

        long memberCount = countMembers();
        if (memberCount > 0 && !dummySeedForce) {
            log.info("[DummyDataInitializer] skip dummy seed - member table already has {} rows", memberCount);
            return;
        }

        log.warn("[DummyDataInitializer] running dummy.sql enabled={} force={} memberCount={}",
                dummySeedEnabled,
                dummySeedForce,
                memberCount);

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("sql/dummy.sql"));
        populator.setContinueOnError(false);
        populator.setIgnoreFailedDrops(false);
        populator.execute(dataSource);

        log.info("[DummyDataInitializer] dummy.sql finished");
    }

    private long countMembers() {
        try {
            Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member", Long.class);
            return count == null ? 0L : count;
        } catch (DataAccessException ex) {
            log.warn("[DummyDataInitializer] failed to count members, treating as empty", ex);
            return 0L;
        }
    }
}
