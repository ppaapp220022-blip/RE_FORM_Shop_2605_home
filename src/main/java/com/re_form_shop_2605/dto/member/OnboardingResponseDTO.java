package com.re_form_shop_2605.dto.member;

import com.re_form_shop_2605.entity.Enum.Sport;

import java.util.List;

// 관심 정보 조회/저장 응답 DTO
public record OnboardingResponseDTO(
        // 관심 종목
        Sport sport,
        // 관심 구단명
        String team,
        // 관심 키워드 목록
        List<String> keywords
) {
}
