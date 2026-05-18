package com.re_form_shop_2605.dto.draft;

import com.re_form_shop_2605.dto.AI.RiskAnalysisResultDTO;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 김민기
 * 작성일: 2026-05-18
 * 설명: 게시글 초안 + 실시간 모더레이션 결과 응답 DTO
 * ─────────────────────────────────────────────────────
 */
public record PostDraftStateDTO(
        PostDraftDTO draft,
        RiskAnalysisResultDTO moderation
) {
}
