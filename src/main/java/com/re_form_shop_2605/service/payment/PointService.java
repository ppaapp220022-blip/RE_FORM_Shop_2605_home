package com.re_form_shop_2605.service.payment;

import com.re_form_shop_2605.dto.payment.PointHistoryItemDTO;
import com.re_form_shop_2605.dto.payment.PointWalletResponseDTO;
import com.re_form_shop_2605.entity.payment.PointHistory;
import com.re_form_shop_2605.entity.payment.PointWallet;
import com.re_form_shop_2605.repository.payment.PointHistoryRepository;
import com.re_form_shop_2605.repository.payment.PointWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointWalletRepository pointWalletRepository;
    private final PointHistoryRepository pointHistoryRepository;

    /* 1. 포인트 지갑 조회 */
    public PointWalletResponseDTO getPointWallet(Long memberId) {
        // 1) memberId로 포인트 지갑 조회
        PointWallet response = pointWalletRepository.findByMemberMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("getPointWallet : 포인트 지갑이 없습니다."));

        // 2) DTO 변환
        return new PointWalletResponseDTO(
                response.getBalance(),
                response.getWithdrawable(),
                response.getPending()
        );
    }

    /* 2. 포인트 이력 조회 */
    public List<PointHistoryItemDTO> getPointHistory(Long memberId) {
        // 1) memberId로 포인트 지갑 조회
        PointWallet wallet = pointWalletRepository.findByMemberMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("getPointHistory : 포인트 지갑이 없습니다."));

        // 2) walletId로 포인트 이력 조회
        List<PointHistory> historyList = pointHistoryRepository.findByPointWalletWalletIdOrderByCreatedAtDesc(wallet.getWalletId());

        // 3) DTO 변환
        List<PointHistoryItemDTO> responses = new ArrayList<>();
        for (PointHistory history : historyList) {
            PointHistoryItemDTO dto = new PointHistoryItemDTO(
                    history.getPointId(),
                    history.getType(),
                    history.getChangeAmount(),
                    history.getBalance(),
                    history.getTrade() != null ? history.getTrade().getTradeId() : null,
                    history.getCreatedAt());

            responses.add(dto);
        }
        return responses;
    }
}