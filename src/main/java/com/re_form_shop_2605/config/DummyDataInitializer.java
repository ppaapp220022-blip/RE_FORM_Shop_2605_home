package com.re_form_shop_2605.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 홈서버 초기 배포 시점에만 더미 SQL을 선택적으로 실행한다.
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class DummyDataInitializer implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.seed.dummy.enabled:false}")
    private boolean dummySeedEnabled;

    @Value("${app.seed.dummy.force:false}")
    private boolean dummySeedForce;

    @Value("${app.seed.dummy.sync-passwords:false}")
    private boolean dummySeedSyncPasswords;

    @Value("${spring.servlet.multipart.location:./uploads}")
    private String uploadRoot;

    @Override
    public void run(ApplicationArguments args) {
        ensureSeedImages();

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

        syncDummyPasswords();
        log.info("[DummyDataInitializer] dummy.sql finished");
    }

    private void syncDummyPasswords() {
        if (!dummySeedSyncPasswords) {
            log.info("[DummyDataInitializer] skip dummy password sync - disabled");
            return;
        }

        try {
            String encodedPassword = passwordEncoder.encode("1234");
            int updatedCount = jdbcTemplate.update(
                    """
                    UPDATE member
                    SET password = ?
                    WHERE email = 'admin@reform.com'
                       OR email LIKE 'user%@reform.com'
                    """,
                    encodedPassword
            );
            log.info("[DummyDataInitializer] synced dummy passwords to raw=1234 updatedCount={}", updatedCount);
        } catch (DataAccessException ex) {
            log.warn("[DummyDataInitializer] failed to sync dummy passwords", ex);
        }
    }

    private void ensureSeedImages() {
        Path seedTargetDirectory = Path.of(uploadRoot).toAbsolutePath().normalize().resolve("post").resolve("seed");

        try {
            Files.createDirectories(seedTargetDirectory);

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] seedResources = resolver.getResources("classpath:seed/post/seed/*.svg");

            for (Resource seedResource : seedResources) {
                String fileName = seedResource.getFilename();
                if (fileName == null || fileName.isBlank()) {
                    continue;
                }

                Path targetPath = seedTargetDirectory.resolve(fileName).normalize();
                try (InputStream inputStream = seedResource.getInputStream()) {
                    Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ex) {
            log.warn("[DummyDataInitializer] failed to prepare seed images in {}", seedTargetDirectory, ex);
        }
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
