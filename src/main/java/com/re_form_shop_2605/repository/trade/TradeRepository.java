package com.re_form_shop_2605.repository.trade;

import com.re_form_shop_2605.entity.Enum.TradeStatus;
import com.re_form_shop_2605.entity.trade.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    int countBySeller_MemberIdAndStatus(Long memberId, TradeStatus status);

    int countByBuyer_MemberIdAndStatus(Long memberId, TradeStatus status);

    boolean existsByPost_PostId(Long postId);

    List<Trade> findAllByBuyer_MemberIdOrderByTradeIdDesc(Long buyerId);

    List<Trade> findAllBySeller_MemberIdOrderByTradeIdDesc(Long sellerId);
}
