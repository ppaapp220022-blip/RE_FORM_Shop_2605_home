package com.re_form_shop_2605.repository.etc;

import com.re_form_shop_2605.entity.etc.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByMember_MemberIdOrderByReportIdDesc(Long reporterId);
}
