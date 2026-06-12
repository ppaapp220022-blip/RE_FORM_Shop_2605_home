package com.re_form_shop_2605.config.db;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * 작성자: 손민정
 * 작성일: 2026-05-13
 * 설명: DB DataSource 충돌 방지
 *      - 오류 1) Spring AI PgVectorStore 자동 설정이 @Primary인 MariaDB에 접근
 *              => PGVectorStore 빈 직접 생성해 PostgreSQL DataSource 명시적 주입
 */

@Configuration
public class PostgresSQLConfig {
    private final String driverClassName;
    private final String jdbcUrl;
    private final String username;
    private final String password;
    private final boolean initializeSchema;

    public PostgresSQLConfig(
            @Value("${spring.datasource.postgres.driver-class-name:org.postgresql.Driver}") String driverClassName,
            @Value("${spring.datasource.postgres.url:jdbc:postgresql://localhost:5432/reform_vector}") String jdbcUrl,
            @Value("${spring.datasource.postgres.username:postgres}") String username,
            @Value("${spring.datasource.postgres.password:postgres}") String password,
            @Value("${spring.ai.vectorstore.pgvector.initialize-schema:false}") boolean initializeSchema
    ) {
        this.driverClassName = driverClassName;
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        this.initializeSchema = initializeSchema;
    }

    /* 벡터 데이터 (AI)
       - spring.datasource.postgres.* 값 읽어옴
      */
    @Bean(name = "postgresDataSource")
    public DataSource postgresDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PgVectorStore vectorStore(EmbeddingModel embeddingModel,
                                     @Qualifier("postgresDataSource") DataSource dataSource) {
        return PgVectorStore.builder(new JdbcTemplate(dataSource), embeddingModel)
                .initializeSchema(initializeSchema)
                .build();
    }
}
