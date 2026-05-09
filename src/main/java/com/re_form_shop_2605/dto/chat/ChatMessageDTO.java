package com.re_form_shop_2605.dto.chat;

import java.time.LocalDateTime;

// WebSocket 메시지 및 이력 조회 공통 사용
public record ChatMessageDTO(
        Long messageId,
        Long senderId,
        String content,
        String type, // "TEXT" | "IMAGE" | "SYSTEM"
        LocalDateTime sentAt,
        boolean isRead
) {}