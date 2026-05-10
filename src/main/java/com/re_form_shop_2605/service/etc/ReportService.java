package com.re_form_shop_2605.service.etc;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.etc.ReportRequestDTO;
import com.re_form_shop_2605.dto.etc.ReportResponseDTO;

// 신고 서비스 인터페이스
public interface ReportService {
    // 신고를 등록
    Long addReport(Long reporterId, ReportRequestDTO reportRequestDTO);

    // 신고를 단건 조회
    ReportResponseDTO readReport(Long reportId);

    // 신고 목록을 페이지 단위로 조회
    PageResponse<ReportResponseDTO> readReports(Long reporterId, int page, int size);
}
