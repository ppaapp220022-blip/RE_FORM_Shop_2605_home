package com.re_form_shop_2605.dto.payment;

import com.re_form_shop_2605.entity.Enum.PointHistoryType;

import java.time.LocalDateTime;

public record PointHistoryItemDTO(
        Long pointId,
        PointHistoryType type,    // EARN | WITHDRAW
        int changeAmount,         // 변동량 (양수/음수)
        int balance,              // 변동 후 잔액
        Long tradeId,             // 연결 거래 ID (null 가능)
        LocalDateTime createdAt
) {
    /* UC-PAY-005 : 포인트 적립/차감 이력 최신순 조회 */
}
