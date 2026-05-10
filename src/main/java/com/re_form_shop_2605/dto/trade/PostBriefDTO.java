package com.re_form_shop_2605.dto.trade;

import com.re_form_shop_2605.entity.Enum.PostStatus;

// 채팅/거래에서 재사용하는 판매글 요약 DTO
public record PostBriefDTO(
        // 게시글 번호
        Long postId,
        // 제목
        String title,
        // 대표 이미지 URL
        String thumbnailUrl,
        // 가격
        int price,
        // 판매 상태
        PostStatus status
) {
}
