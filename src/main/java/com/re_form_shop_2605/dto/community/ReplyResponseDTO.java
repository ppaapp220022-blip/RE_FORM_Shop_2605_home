package com.re_form_shop_2605.dto.community;

import com.re_form_shop_2605.dto.chat.MemberBriefDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ReplyResponseDTO(
        Long replyId,
        MemberBriefDTO author,
        String replyContent,
        int likeCount,
        boolean isLiked,
        boolean isDeleted,
        LocalDateTime createdAt,
        List<ReplyResponseDTO> children // 대댓글 목록 (최대 1단계)
) {
}
