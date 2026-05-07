package com.re_form_shop_2605.repository.payment;

import com.re_form_shop_2605.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    /* 결제 저장 및 조회 */
}