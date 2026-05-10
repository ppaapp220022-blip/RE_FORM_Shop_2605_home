package com.re_form_shop_2605.service.trade;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.trade.DeliveryRequestDTO;
import com.re_form_shop_2605.dto.trade.ReviewRequestDTO;
import com.re_form_shop_2605.dto.trade.ReviewResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeRequestDTO;
import com.re_form_shop_2605.dto.trade.TradeResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeStatusRequestDTO;
import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.Grade;
import com.re_form_shop_2605.entity.Enum.MemberStatus;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.Role;
import com.re_form_shop_2605.entity.Enum.Sport;
import com.re_form_shop_2605.entity.Enum.TradeStatus;
import com.re_form_shop_2605.entity.member.Member;
import com.re_form_shop_2605.entity.trade.Post;
import com.re_form_shop_2605.entity.trade.Trade;
import com.re_form_shop_2605.repository.member.MemberRepository;
import com.re_form_shop_2605.repository.trade.PostRepository;
import com.re_form_shop_2605.repository.trade.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@SpringBootTest
//@Transactional
class TradeServiceImplTest {

    @Autowired
    private TradeService tradeService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TradeRepository tradeRepository;

    @Test
    void addTradeTest() {
        Member seller = createMember("add_trade_seller");
        Member buyer = createMember("add_trade_buyer");
        Post post = createPost(seller, "trade add");

        Long tradeId = tradeService.addTrade(buyer.getMemberId(), new TradeRequestDTO(post.getPostId()));

        assertNotNull(tradeId);
    }

    @Test
    void readTradeTest() {
        Member seller = createMember("read_trade_seller");
        Member buyer = createMember("read_trade_buyer");
        Trade trade = createTrade(seller, buyer, "read trade");

        TradeResponseDTO responseDTO = tradeService.readTrade(trade.getTradeId());

        assertEquals(trade.getTradeId(), responseDTO.tradeId());
        assertEquals(buyer.getMemberId(), responseDTO.buyer().memberId());
    }

    @Test
    void readBuyerTradesTest() {
        Member buyer = createMember("buyer_trades_buyer");
        for (int i = 0; i < 10; i++) {
            Member seller = createMember("buyer_trades_seller_" + i);
            createTrade(seller, buyer, "buyer_trade_" + i);
        }

        PageResponse<TradeResponseDTO> trades = tradeService.readBuyerTrades(buyer.getMemberId(), 0, 10);
        assertEquals(10, trades.content().size());
    }

    @Test
    void readSellerTradesTest() {
        Member seller = createMember("seller_trades_seller");
        for (int i = 0; i < 10; i++) {
            Member buyer = createMember("seller_trades_buyer_" + i);
            createTrade(seller, buyer, "seller_trade_" + i);
        }

        PageResponse<TradeResponseDTO> trades = tradeService.readSellerTrades(seller.getMemberId(), 0, 10);
        assertEquals(10, trades.content().size());
    }

    @Test
    void modifyTradeStatusTest() {
        Member seller = createMember("modify_status_seller");
        Member buyer = createMember("modify_status_buyer");
        Trade trade = createTrade(seller, buyer, "modify status");

        tradeService.modifyTradeStatus(trade.getTradeId(), new TradeStatusRequestDTO(TradeStatus.ACCEPTED));

        assertEquals(TradeStatus.ACCEPTED, tradeRepository.findById(trade.getTradeId()).orElseThrow().getStatus());
    }

    @Test
    void modifyDeliveryTest() {
        Member seller = createMember("modify_delivery_seller");
        Member buyer = createMember("modify_delivery_buyer");
        Trade trade = createTrade(seller, buyer, "modify delivery");

        tradeService.modifyDelivery(trade.getTradeId(), new DeliveryRequestDTO("서울시 강남구"));

        assertEquals("서울시 강남구", tradeRepository.findById(trade.getTradeId()).orElseThrow().getDeliveryAddress());
    }

    @Test
    void addReviewTest() {
        Member seller = createMember("add_review_seller");
        Member buyer = createMember("add_review_buyer");
        Trade trade = createCompletedTrade(seller, buyer, "add review");

        Long reviewId = tradeService.addReview(buyer.getMemberId(), new ReviewRequestDTO(trade.getTradeId(), 5, "좋아요"));

        assertNotNull(reviewId);
    }

    @Test
    void readReviewTest() {
        Member seller = createMember("read_review_seller");
        Member buyer = createMember("read_review_buyer");
        Trade trade = createCompletedTrade(seller, buyer, "read review");
        Long reviewId = tradeService.addReview(buyer.getMemberId(), new ReviewRequestDTO(trade.getTradeId(), 4, "괜찮아요"));

        ReviewResponseDTO responseDTO = tradeService.readReview(reviewId);

        assertEquals(reviewId, responseDTO.mannerId());
        assertEquals("괜찮아요", responseDTO.content());
    }

    @Test
    void readSellerReviewsTest() {
        Member seller = createMember("seller_reviews_seller");
        for (int i = 0; i < 10; i++) {
            Member buyer = createMember("seller_reviews_buyer_" + i);
            Trade trade = createCompletedTrade(seller, buyer, "seller review " + i);
            tradeService.addReview(buyer.getMemberId(), new ReviewRequestDTO(trade.getTradeId(), 5, "review_" + i));
        }

        PageResponse<ReviewResponseDTO> reviews = tradeService.readSellerReviews(seller.getMemberId(), 0, 10);
        assertEquals(10, reviews.content().size());
    }

    private Member createMember(String prefix) {
        long seed = System.nanoTime();
        Member member = Member.builder()
                .email(prefix + "_" + seed + "@test.com")
                .password("1234")
                .nickname(prefix + "_" + seed)
                .mannerScore(BigDecimal.ZERO)
                .role(Role.USER)
                .status(MemberStatus.ACTIVE)
                .warningCount(0)
                .emailEvent(true)
                .build();
        return memberRepository.save(member);
    }

    private Post createPost(Member seller, String title) {
        Post post = Post.builder()
                .sellerId(seller)
                .title(title)
                .content("content")
                .sport(Sport.BASEBALL)
                .team("LG")
                .uniformName("uniform")
                .grade(Grade.A)
                .size("100")
                .marking(false)
                .price(10000)
                .deliveryType(DeliveryType.DIRECT)
                .status(PostStatus.ON_SALE)
                .viewCount(0)
                .wishCount(0)
                .build();
        return postRepository.save(post);
    }

    private Trade createTrade(Member seller, Member buyer, String title) {
        Post post = createPost(seller, title);
        return tradeRepository.save(Trade.builder()
                .post(post)
                .buyer(buyer)
                .seller(seller)
                .status(TradeStatus.REQUESTED)
                .tradePrice(10000)
                .build());
    }

    private Trade createCompletedTrade(Member seller, Member buyer, String title) {
        Post post = createPost(seller, title);
        return tradeRepository.save(Trade.builder()
                .post(post)
                .buyer(buyer)
                .seller(seller)
                .status(TradeStatus.COMPLETED)
                .tradePrice(10000)
                .build());
    }
}
