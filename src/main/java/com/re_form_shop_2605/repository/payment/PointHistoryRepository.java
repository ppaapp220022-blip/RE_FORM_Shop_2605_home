package com.re_form_shop_2605.repository.payment;

import com.re_form_shop_2605.entity.payment.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {
    /* 포인트 이력 */
    // 1. 지갑 ID로 포인트 이력 최신순 조회
    List<PointHistory> findByPointWalletWalletIdOrderByCreatedAtDesc(Long walletId);
}
