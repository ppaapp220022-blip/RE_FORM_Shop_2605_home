package com.re_form_shop_2605.dto.AI;

import com.re_form_shop_2605.entity.trade.Post;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 손민정
 * 작성일: 2026-05-14
 * 설명: 위험 탐지 배치 Processor -> Writer 전달용 DTO
 *      - 용도 : Writer에서 post 상태 업데이트
 *      - post: 위험 탐지 대상 게시글
 *      - riskAnalysisResultDTO: AI 분석 결과 (riskLevel, reason, suggestion)
 * ─────────────────────────────────────────────────────
 */

public record RiskDetectionResultDTO(Post post,
                                     RiskAnalysisResultDTO riskAnalysisResultDTO) {
}