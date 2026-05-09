package com.re_form_shop_2605.dto.community;

import jakarta.validation.constraints.NotBlank;

// POST /api/community/{commId}/replies
public record ReplyCreateRequestDTO(
        @NotBlank
        String replyContent,
        Long parentId // 대댓글인 경우 부모 replyId, 최상위면 null
) {}
