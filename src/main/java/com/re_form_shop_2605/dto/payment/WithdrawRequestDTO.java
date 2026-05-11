package com.re_form_shop_2605.dto.payment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WithdrawRequestDTO(
        @NotNull @Min(1000)
        int requestAmount,

        @NotBlank @Size(max = 50)
        String bankName,

        @NotBlank @Size(max = 30)
        String accountNumber
) {
}
