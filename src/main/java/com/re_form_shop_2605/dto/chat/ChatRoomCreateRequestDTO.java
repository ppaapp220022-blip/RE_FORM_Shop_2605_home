package com.re_form_shop_2605.dto.chat;

import org.jetbrains.annotations.NotNull;

// POST /api/chats
public record ChatRoomCreateRequestDTO(
        @NotNull
        Long postId // 연결할 판매글 ID
) {}
