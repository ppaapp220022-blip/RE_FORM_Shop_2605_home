package com.re_form_shop_2605.repository.payment;

import com.re_form_shop_2605.entity.payment.TossLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TossLogRepository extends JpaRepository<TossLog, Long> {
    /* 토스 로그 저장 */
}
