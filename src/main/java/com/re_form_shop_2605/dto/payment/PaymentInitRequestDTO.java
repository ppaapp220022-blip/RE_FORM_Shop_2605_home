package com.re_form_shop_2605.dto.payment;

import com.re_form_shop_2605.entity.Enum.PayMethod;
import org.jetbrains.annotations.NotNull;

public record PaymentInitRequestDTO(
        @NotNull Long tradeId,
        @NotNull PayMethod payMethod) {
    /* 결제 요청 DTO (프론트 -> 백) */
}
