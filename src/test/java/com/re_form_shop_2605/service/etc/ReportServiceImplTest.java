package com.re_form_shop_2605.service.etc;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.etc.ReportRequestDTO;
import com.re_form_shop_2605.dto.etc.ReportResponseDTO;
import com.re_form_shop_2605.entity.Enum.MemberStatus;
import com.re_form_shop_2605.entity.Enum.ReportReason;
import com.re_form_shop_2605.entity.Enum.ReportTargetType;
import com.re_form_shop_2605.entity.Enum.Role;
import com.re_form_shop_2605.entity.member.Member;
import com.re_form_shop_2605.repository.member.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@SpringBootTest
//@Transactional
class ReportServiceImplTest {

    @Autowired
    private ReportService reportService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void addReportTest() {
        Member reporter = createMember("add_report");

        Long reportId = reportService.addReport(
                reporter.getMemberId(),
                new ReportRequestDTO(ReportTargetType.POST, 1L, ReportReason.ETC, "신고 상세")
        );
        assertNotNull(reportId);
    }

    @Test
    void readReportTest() {
        Member reporter = createMember("read_report");
        Long reportId = reportService.addReport(
                reporter.getMemberId(),
                new ReportRequestDTO(ReportTargetType.POST, 2L, ReportReason.FAKE, "가짜 게시글")
        );
        ReportResponseDTO responseDTO = reportService.readReport(reportId);
        assertEquals(reportId, responseDTO.reportId());
        assertEquals(ReportReason.FAKE, responseDTO.reason());
    }

    @Test
    void readReportsTest() {
        Member reporter = createMember("read_reports");
        for (int i = 0; i < 10; i++) {
            reportService.addReport(
                    reporter.getMemberId(),
                    new ReportRequestDTO(ReportTargetType.POST, (long) i, ReportReason.ETC, "detail_" + i)
            );
        }
        PageResponse<ReportResponseDTO> reports = reportService.readReports(reporter.getMemberId(), 0, 10);
        assertEquals(10, reports.content().size());
    }

    private Member createMember(String prefix) {
        long seed = System.nanoTime();
        Member member = Member.builder()
                .email(prefix + "_" + seed + "@test.com")
                .password("1234")
                .nickname(prefix + "_" + seed)
                .mannerScore(BigDecimal.ZERO)
                .role(Role.USER)
                .status(MemberStatus.ACTIVE)
                .warningCount(0)
                .emailEvent(true)
                .build();
        return memberRepository.save(member);
    }
}
