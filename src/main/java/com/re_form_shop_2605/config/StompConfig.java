package com.re_form_shop_2605.config;

import com.re_form_shop_2605.security.JWT.CustomUserDetailsService;
import com.re_form_shop_2605.security.JWT.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.Arrays;

@Configuration(proxyBeanMethods = false)
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * ─────────────────────────────────────────────────────
     * 작성자: 진혜림
     * 작성일: 2026-05-08
     * 설명: STOMP 프로토콜을 사용한 웹소켓 메시지 브로커 설정 클래스
     * ─────────────────────────────────────────────────────
     */
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetailsService;
    private final String[] allowedOriginPatterns;

    public StompConfig(
            JwtTokenProvider jwtTokenProvider,
            CustomUserDetailsService customUserDetailsService,
            @Value("${app.cors.allowed-origin-patterns:http://localhost:5173}") String allowedOriginPatterns
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService = customUserDetailsService;
        this.allowedOriginPatterns = Arrays.stream(allowedOriginPatterns.split(","))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .toArray(String[]::new);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")
                .setAllowedOriginPatterns(allowedOriginPatterns);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /* 메시지 브로커를 구성하여 클라이언트가 메시지를 발행하거나 구독할 때 사용할 경로를 설정 */
        registry.setApplicationDestinationPrefixes("/pub");
        registry.enableSimpleBroker("/sub");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (accessor == null || accessor.getCommand() != StompCommand.CONNECT) {
                    return message;
                }

                String token = resolveBearerToken(accessor);
                if (!StringUtils.hasText(token)
                        || !jwtTokenProvider.validateToken(token)
                        || !"access".equals(jwtTokenProvider.getTokenType(token))) {
                    throw new IllegalArgumentException("유효한 STOMP 인증 토큰이 아닙니다.");
                }

                UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtTokenProvider.getSubject(token));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                accessor.setUser(authentication);
                return message;
            }
        });
    }

    private String resolveBearerToken(StompHeaderAccessor accessor) {
        String authorization = accessor.getFirstNativeHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authorization)) {
            authorization = accessor.getFirstNativeHeader("authorization");
        }
        if (!StringUtils.hasText(authorization) || !authorization.startsWith("Bearer ")) {
            return null;
        }
        return authorization.substring(7);
    }
}
