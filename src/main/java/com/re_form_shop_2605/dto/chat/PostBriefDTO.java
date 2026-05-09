package com.re_form_shop_2605.dto.chat;

import com.re_form_shop_2605.entity.Enum.PostStatus;

// GET /api/chats
public record PostBriefDTO(
        Long postId,
        String title,
        String thumbnailUrl,
        int price,
        PostStatus status
) {}