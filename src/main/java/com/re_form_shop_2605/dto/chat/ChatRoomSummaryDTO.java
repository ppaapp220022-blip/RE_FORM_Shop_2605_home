package com.re_form_shop_2605.dto.chat;

import java.time.LocalDateTime;

// GET /api/chats
public record ChatRoomSummaryDTO(
        Long chatId,
        MemberBriefDTO partner, // 상대방 (내가 구매자면 seller, 판매자면 buyer)
        String lastMessage, // 마지막 메시지 내용 (미리보기)
        LocalDateTime lastMessageAt,
        int unreadCount,
        PostBriefDTO post // 연결된 판매글 요약
) {}
