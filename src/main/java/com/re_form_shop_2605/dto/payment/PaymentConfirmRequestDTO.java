package com.re_form_shop_2605.dto.payment;

import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;

public record PaymentConfirmRequestDTO(
        @NotBlank String paymentKey,
        @NotBlank String orderId,
        @NotNull Integer amount
) {
    /* 결제 승인 요청 DTO (프론트 -> 백) */
}
