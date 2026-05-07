package com.re_form_shop_2605.repository.trade;

import com.re_form_shop_2605.entity.trade.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    /* 거래 상태 변경 */

}
