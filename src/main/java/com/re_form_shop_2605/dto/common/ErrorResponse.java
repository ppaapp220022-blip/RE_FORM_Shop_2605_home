package com.re_form_shop_2605.dto.common;


import java.time.LocalDateTime;

// 에러
public record ErrorResponse(
        String code, String message, LocalDateTime timestamp
) {
}
