package com.re_form_shop_2605.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * 작성자: 최민종
 * 작성일: 2026-05-14
 * 설명:
 * CORS(Cross-Origin Resource Sharing) 설정을 위한 구성 클래스
 * 서로 다른 도메인/포트(예: localhost:5173 -> localhost:8080) 간의 자원 공유를 허용
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final String[] allowedOriginPatterns;

    public WebConfig(
            @Value("${app.cors.allowed-origin-patterns:http://localhost:5173}") String allowedOriginPatterns
    ) {
        this.allowedOriginPatterns = Arrays.stream(allowedOriginPatterns.split(","))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .toArray(String[]::new);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(allowedOriginPatterns)
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Authorization", "Set-Cookie")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
