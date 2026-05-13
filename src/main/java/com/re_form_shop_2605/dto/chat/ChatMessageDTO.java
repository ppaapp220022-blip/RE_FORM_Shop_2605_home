package com.re_form_shop_2605.dto.chat;

import com.re_form_shop_2605.dto.etc.RiskAnalysisResultDTO;

import java.time.LocalDateTime;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 진혜림
 * 작성일: 2026-05-13
 * 설명: WebSocket 메시지 DTO
 * ─────────────────────────────────────────────────────
 */
public record ChatMessageDTO(
        Long messageId,
        Long senderId,
        String content,
        String type, // "TEXT" | "IMAGE" | "SYSTEM"
        LocalDateTime createdAt,
        boolean isRead,
        RiskAnalysisResultDTO moderation
) {}