package com.re_form_shop_2605.controller.admin;

import com.re_form_shop_2605.dto.AI.RiskAnalysisResultDTO;
import com.re_form_shop_2605.service.admin.AdminRiskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 작성자: 손민정
 * 작성일: 2026-05-14
 * 설명: 관리자 위험 탐지 결 조회 API
 *     - AI 위험 탐지 배치 분석 결과 조회
 *     - riskLevel 필터로 LOW | MID | HIGH 구분 조회
 *     - ADMIN 권한 필요
 */

@Log4j2
@RestController
@RequestMapping("/api/admin/risk")
@Tag(name = "관리자 위험 탐지 API", description = "AI 위험 탐지 배치 분석 결과 조회 API (게시글 / 채팅)")
@RequiredArgsConstructor
public class AdminRiskController {
    private final AdminRiskService adminRiskService;

    @Operation(summary = "위험 게시글 목록 조회", description = "AI 위험 탐지 배치 분석 결과 중 HIGH 등급 게시글 목록 조회")
    @GetMapping("/posts")
    public ResponseEntity<List<RiskAnalysisResultDTO>> viewRiskDetectionResult() {
        log.info("==== viewRiskDetectionResult 판매 게시글 위험 탐지 중 ... ====");

        List<RiskAnalysisResultDTO> riskAnalysisResult = adminRiskService.getRiskAnalysisResult();

        return ResponseEntity.ok(riskAnalysisResult);
    }
}