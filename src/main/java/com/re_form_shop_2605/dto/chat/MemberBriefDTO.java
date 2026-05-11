package com.re_form_shop_2605.dto.chat;

// GET /api/chats
public record MemberBriefDTO(
        Long memberId,
        String nickname,
        String profileImageUrl
) {}