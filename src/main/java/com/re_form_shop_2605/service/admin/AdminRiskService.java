package com.re_form_shop_2605.service.admin;

import com.re_form_shop_2605.dto.AI.RiskAnalysisResultDTO;
import com.re_form_shop_2605.entity.Enum.RiskLevel;
import com.re_form_shop_2605.entity.Enum.TargetType;
import com.re_form_shop_2605.entity.etc.RiskAnalysisResult;
import com.re_form_shop_2605.repository.AI.RiskAnalysisResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 작성자: 손민정
 * 작성일: 2026-05-14
 * 설명: 관리자 위험 탐지 결과 조회 서비스
 *      - AI 위험 탐지 배치 분석 결과 조회 (현재 POST + HIGH 등급만 반환)
 */

@Service
@RequiredArgsConstructor
public class AdminRiskService {
    private final RiskAnalysisResultRepository riskAnalysisResultRepository;

    /* TargetType = 'POST' + riskLevel = 'HIGH'인 게시글 목록 조회 */
    public List<RiskAnalysisResultDTO> getRiskAnalysisResult() {
        TargetType targetType = TargetType.POST;
        RiskLevel riskLevel = RiskLevel.HIGH;

        List<RiskAnalysisResult> results = riskAnalysisResultRepository
                .findByTargetTypeAndRiskLevelOrderByCreatedAtDesc(targetType, riskLevel);

        List<RiskAnalysisResultDTO> resultDTOList = results.stream()
                .map(result -> RiskAnalysisResultDTO.from(result))
                .toList();

        return resultDTOList;
    }
}