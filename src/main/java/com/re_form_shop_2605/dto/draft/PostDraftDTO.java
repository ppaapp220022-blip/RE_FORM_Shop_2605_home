package com.re_form_shop_2605.dto.draft;

import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.Grade;
import com.re_form_shop_2605.entity.Enum.Sport;
import jakarta.validation.constraints.Size;

import java.util.List;
/**
 * ─────────────────────────────────────────────────────
 * 작성자: 김민기
 * 작성일: 2026-05-11
 * 설명: 게시글 작성 중 임시 저장할 초안 DTO
 * ─────────────────────────────────────────────────────
 */
public record PostDraftDTO(
        // 게시글 제목
        @Size(max = 200)
        String title,

        // 게시글 본문
        @Size(max = 2000)
        String content,

        // 종목
        Sport sport,

        // 구단명
        @Size(max = 50)
        String team,

        // 등번호 또는 마킹명
        @Size(max = 50)
        String uniformNumber,

        // 유니폼 상태
        Grade condition,

        // 유니폼 사이즈
        @Size(max = 10)
        String size,

        // 거래 방식
        DeliveryType tradeType,

        // 가격
        Integer price,

        // 직거래 지역
        @Size(max = 200)
        String directTradeLocation,

        // 업로드된 이미지 URL 목록
        @Size(max = 10)
        List<@Size(max = 500) String> imageUrls
) {
}
