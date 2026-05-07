package com.re_form_shop_2605.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrePaymentResponseDTO {
    /* 결제 시 프론트에 넘겨줄 데이터
       - 토스 결제창 띄울 때 필요한 값
    */
    private String tossOrderId;
    private Integer amount;
    private String orderName;
}
