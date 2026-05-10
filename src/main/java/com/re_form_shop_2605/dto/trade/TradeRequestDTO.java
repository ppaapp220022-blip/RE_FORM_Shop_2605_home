package com.re_form_shop_2605.dto.trade;

import jakarta.validation.constraints.NotNull;

// 거래 생성 요청 DTO
public record TradeRequestDTO(
        // 거래를 생성할 판매글 번호
        @NotNull
        Long postId
) {
}
