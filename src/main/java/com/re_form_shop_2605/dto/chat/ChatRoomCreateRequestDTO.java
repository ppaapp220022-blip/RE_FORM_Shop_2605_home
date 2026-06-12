package com.re_form_shop_2605.dto.chat;

import org.jetbrains.annotations.NotNull;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 진혜림
 * 작성일: 2026-05-09
 * 설명: 채팅방 생성용 DTO
 * ─────────────────────────────────────────────────────
 */
// POST /api/chats
public record ChatRoomCreateRequestDTO(
        @NotNull
        Long postId // 연결할 판매글 ID
) {}
