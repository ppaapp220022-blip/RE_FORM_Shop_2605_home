package com.re_form_shop_2605.dto.payment;

public record PaymentCancelRequestDTO(
        String cancelReason, // 취소 사유
        String cancelType	 // CANCEL or REFUND
) {
}