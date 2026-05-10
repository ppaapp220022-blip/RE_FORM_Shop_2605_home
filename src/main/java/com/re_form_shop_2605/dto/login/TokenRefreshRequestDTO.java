package com.re_form_shop_2605.dto.login;

// 액세스 토큰 재발급 요청 DTO
public record TokenRefreshRequestDTO(
        // 리프레시 토큰
        String refreshToken
) {
}
