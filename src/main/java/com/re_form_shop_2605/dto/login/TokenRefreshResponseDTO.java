package com.re_form_shop_2605.dto.login;

// 액세스 토큰 재발급 응답 DTO
public record TokenRefreshResponseDTO(
        // 새 액세스 토큰
        String accessToken
) {
}
