package com.re_form_shop_2605.controller.payment;

import com.re_form_shop_2605.service.payment.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PointControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private PointService pointService;

    @Test
    @WithMockUser
    void testViewPointWallet() throws Exception {
        mockMvc.perform(get("/api/points/wallet")
                        .param("memberId", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testWithdraw() throws Exception {
        mockMvc.perform(post("/api/points/withdraw")
                .param("memberId", "3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "requestAmount": 10000,
                            "bankName": "은행3",
                            "accountNumber": "333-33-333333"
                        }
                        """)
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void testGetWithdrawList() throws Exception {
        mockMvc.perform(get("/api/points/withdraw")
                .param("memberId", "2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testCancelWithdraw() throws Exception {
        mockMvc.perform(delete("/api/points/cancel/{withdrawId}", 6L)
                        .param("memberId", "3")
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
