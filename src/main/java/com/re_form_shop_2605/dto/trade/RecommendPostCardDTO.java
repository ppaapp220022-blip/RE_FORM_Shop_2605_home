package com.re_form_shop_2605.dto.trade;

import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.Grade;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.Sport;

import java.time.LocalDateTime;

public record RecommendPostCardDTO(
        Long postId,
        String title,
        String team,
        Sport sport,
        int price,
        Grade grade,
        String size,
        DeliveryType deliveryType,
        PostStatus status,
        int viewCount,
        int wishCount,
        String thumbnailUrl,
        LocalDateTime createdAt,
        String recommendReason
) {
    public static RecommendPostCardDTO from(PostCardDTO postCardDTO, String recommendReason) {
        return new RecommendPostCardDTO(
                postCardDTO.postId(),
                postCardDTO.title(),
                postCardDTO.team(),
                postCardDTO.sport(),
                postCardDTO.price(),
                postCardDTO.grade(),
                postCardDTO.size(),
                postCardDTO.deliveryType(),
                postCardDTO.status(),
                postCardDTO.viewCount(),
                postCardDTO.wishCount(),
                postCardDTO.thumbnailUrl(),
                postCardDTO.createdAt(),
                recommendReason
        );
    }
}
