package com.re_form_shop_2605.dto.payment;

import com.re_form_shop_2605.entity.Enum.PointRequestStatus;

import java.time.LocalDateTime;

public record WithdrawResponseDTO(
        Long withdrawId,
        int requestAmount,
        String bankName,
        String accountNumber,
        PointRequestStatus status,
        LocalDateTime createdAt
) {
}
