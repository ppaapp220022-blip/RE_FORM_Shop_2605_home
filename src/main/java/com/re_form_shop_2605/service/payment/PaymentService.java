package com.re_form_shop_2605.service.payment;

import com.re_form_shop_2605.repository.payment.PaymentRepository;
import com.re_form_shop_2605.repository.trade.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final TradeRepository tradeRepository;

    // 1. 결제 요청
    // 1) 거래 조회 -> 거래 반환
    // 2) 요청자가 구매자인지 검증
    // 3) 거래 상태 검증 (ACCEPTED가 아니면 결제 불가)
    // 4) 금액 검증 (DB와 비교해 위변조 감지)
    // 5) tossOrderId 생성 후 저장 => UUID 이용

    // 2. toss 승인 처리 콜백
    // 1) Toss Payments 결제 결과를 서버로 콜백
    // 2) 서버가 결재 금액 재검증
    // 3) 검증 통과 시 토스 승인 api 호출
    // 4) 거래 상태 전환 및 정보 저장
}