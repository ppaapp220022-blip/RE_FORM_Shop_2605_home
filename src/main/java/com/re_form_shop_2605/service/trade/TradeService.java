package com.re_form_shop_2605.service.trade;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.trade.DeliveryRequestDTO;
import com.re_form_shop_2605.dto.trade.ReviewRequestDTO;
import com.re_form_shop_2605.dto.trade.ReviewResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeRequestDTO;
import com.re_form_shop_2605.dto.trade.TradeResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeStatusRequestDTO;

// 거래 관련 서비스 인터페이스
public interface TradeService {

    // 거래 생성
    Long addTrade(Long buyerId, TradeRequestDTO tradeRequestDTO);

    // 거래 단건 조회
    TradeResponseDTO readTrade(Long tradeId);

    // 구매자 기준 거래 목록 조회
    PageResponse<TradeResponseDTO> readBuyerTrades(Long buyerId, int page, int size);

    // 판매자 기준 거래 목록 조회
    PageResponse<TradeResponseDTO> readSellerTrades(Long sellerId, int page, int size);

    // 거래 상태 변경
    void modifyTradeStatus(Long tradeId, TradeStatusRequestDTO tradeStatusRequestDTO);

    // 배송지 정보 수정
    void modifyDelivery(Long tradeId, DeliveryRequestDTO deliveryRequestDTO);

    // 매너 리뷰 등록
    Long addReview(Long buyerId, ReviewRequestDTO reviewRequestDTO);

    // 매너 리뷰 단건 조회
    ReviewResponseDTO readReview(Long mannerId);

    // 판매자 기준 매너 리뷰 목록 조회
    PageResponse<ReviewResponseDTO> readSellerReviews(Long sellerId, int page, int size);
}
