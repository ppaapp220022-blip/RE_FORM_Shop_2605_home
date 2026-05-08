package com.re_form_shop_2605.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class TossWebClientConfig {
    /*
      - 토스페이먼츠 API는 시크릿 키를 사용자 ID로 사용하고, 비밀번호는 사용하지 않음
      - 비밀번호가 없다는 것을 알리기 위해 시크릿 키 뒤에 콜론 추가
    */
    @Value("${toss.secret-key}")
    private String secretKey;

    @Bean
    public WebClient tossWebClient() {
        // 1. secretKey Base64 인코딩
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((secretKey + ":").getBytes(StandardCharsets.UTF_8));
        String encodedKey = new String(encodedBytes);

        // 2. 인코딩된 Authorization 헤더 생성
        String authorizations = "Basic " + encodedKey;

        // 3. WebClient 기본값 설정
        return WebClient.builder()
                .baseUrl("https://api.tosspayments.com")
                .defaultHeader("Authorization", authorizations)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}