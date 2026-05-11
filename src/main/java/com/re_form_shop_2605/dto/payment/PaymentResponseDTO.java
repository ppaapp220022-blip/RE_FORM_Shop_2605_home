package com.re_form_shop_2605.dto.payment;

import com.re_form_shop_2605.entity.Enum.PayMethod;
import com.re_form_shop_2605.entity.Enum.PaymentStatus;

import java.time.LocalDateTime;

public record PaymentResponseDTO(
        Long paymentId, Long tradeId,
        PayMethod payMethod, int amount, PaymentStatus status,
        String approvalNo, LocalDateTime paidAt
) {
    /* 결제 응답 DTO */
}
