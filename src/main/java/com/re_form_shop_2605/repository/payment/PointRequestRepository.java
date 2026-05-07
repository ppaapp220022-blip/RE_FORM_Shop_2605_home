package com.re_form_shop_2605.repository.payment;

import com.re_form_shop_2605.entity.payment.PointRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRequestRepository extends JpaRepository<PointRequest, Long> {
    /* 출금 요청 저장/조회 */
}
