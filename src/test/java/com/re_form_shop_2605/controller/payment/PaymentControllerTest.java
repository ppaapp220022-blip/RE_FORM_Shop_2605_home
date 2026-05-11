package com.re_form_shop_2605.controller.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testPaymentInit() throws Exception {
        // 참고) 프론트 작업 전 테스트 코드
        mockMvc.perform(post("/api/payments/init")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
                        .content("""
                        {
                            "tradeId": 1,
                            "payMethod": "Card"
                        }
                        """))
                .andDo(print()) // 요청/응답 콘솔 출력
                .andExpect(status().isCreated())  // 201 확인
                .andExpect(jsonPath("$.tossOrderId").exists())  // tossOrderId 있는지 확인
                .andExpect(jsonPath("$.amount").value(15000));  // 금액 확인
    }
}