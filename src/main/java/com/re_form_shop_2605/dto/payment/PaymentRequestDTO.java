package com.re_form_shop_2605.dto.payment;

import com.re_form_shop_2605.entity.Enum.PayMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentRequestDTO {
    /* 결제 시 프론트에서 받아와야 할 데이터 */
    private Long tradeId;        // 거래 id
    private Integer amount;      // 결제 금액
    private PayMethod payMethod; // 결제 수단
}
