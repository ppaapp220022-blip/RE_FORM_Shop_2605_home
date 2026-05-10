package com.re_form_shop_2605.repository.trade;

import com.re_form_shop_2605.entity.trade.MannerReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface mannerReviewRepository extends JpaRepository<MannerReview, Long> {
    List<MannerReview> findTop5BySeller_MemberIdOrderByMannerIdDesc(Long memberId);

    List<MannerReview> findAllBySeller_MemberIdOrderByMannerIdDesc(Long sellerId);

    boolean existsByTrade_TradeIdAndBuyer_MemberId(Long tradeId, Long buyerId);
}
