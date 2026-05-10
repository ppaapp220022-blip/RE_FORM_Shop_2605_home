package com.re_form_shop_2605.service.etc;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.etc.ReportRequestDTO;
import com.re_form_shop_2605.dto.etc.ReportResponseDTO;
import com.re_form_shop_2605.entity.etc.Report;
import com.re_form_shop_2605.entity.member.Member;
import com.re_form_shop_2605.repository.etc.ReportRepository;
import com.re_form_shop_2605.repository.member.MemberRepository;
import com.re_form_shop_2605.service.common.ServicePageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReportServiceImpl implements ReportService{
    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    // 신고자 정보를 확인한 뒤 신고를 저장
    public Long addReport(Long reporterId, ReportRequestDTO reportRequestDTO) {
        Member reporter = memberRepository.findById(reporterId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Report mappedReport = modelMapper.map(reportRequestDTO, Report.class);
        Report report = new Report(
                reporter,
                mappedReport.getTargetType(),
                mappedReport.getTargetId(),
                mappedReport.getReason(),
                mappedReport.getDetail()
        );

        return reportRepository.save(report).getReportId();
    }

    @Override
    // 단건 신고를 조회해 응답 DTO로 반환
    public ReportResponseDTO readReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("신고가 존재하지 않습니다."));
        return toReportResponseDTO(report);
    }

    @Override
    // 신고자 기준 신고 내역을 페이지 단위로 반환
    public PageResponse<ReportResponseDTO> readReports(Long reporterId, int page, int size) {
        List<Report> reports = reportRepository.findAllByMember_MemberIdOrderByReportIdDesc(reporterId);
        List<ReportResponseDTO> reportResponseDTOList = new ArrayList<>();

        for (Report report : reports) {
            reportResponseDTOList.add(toReportResponseDTO(report));
        }

        return ServicePageResponse.of(reportResponseDTOList, page, size);
    }

    // 신고 엔티티를 화면용 응답 DTO로 변환
    private ReportResponseDTO toReportResponseDTO(Report report) {
        return new ReportResponseDTO(
                report.getReportId(),
                report.getTargetType(),
                report.getTargetId(),
                report.getReason(),
                report.getDetail(),
                report.getStatus(),
                report.getCreatedAt()
        );
    }
}
