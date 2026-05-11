package com.re_form_shop_2605.controller.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PointControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testViewPointWallet() throws Exception {
        mockMvc.perform(get("/api/points/wallet")
                        .param("memberId", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}