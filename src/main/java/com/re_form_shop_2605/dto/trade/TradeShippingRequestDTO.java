package com.re_form_shop_2605.dto.trade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 김민기
 * 작성일: 2026-05-13
 * 설명: 판매자가 배송 시작 시 입력하는 택배 정보 요청 DTO
 * ─────────────────────────────────────────────────────
 */
public record TradeShippingRequestDTO(
        @NotBlank
        @Size(max = 50)
        String courierCode,

        // 택배사 이름 — 프론트에서 이미 보유한 값을 전달받아 외부 API 재호출 방지
        @NotBlank
        @Size(max = 100)
        String courierName,

        @NotBlank
        @Size(max = 100)
        String trackingNumber
) {
}
