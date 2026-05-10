package com.re_form_shop_2605.service.trade;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.trade.DeliveryRequestDTO;
import com.re_form_shop_2605.dto.trade.MemberBriefDTO;
import com.re_form_shop_2605.dto.trade.PostBriefDTO;
import com.re_form_shop_2605.dto.trade.ReviewRequestDTO;
import com.re_form_shop_2605.dto.trade.ReviewResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeRequestDTO;
import com.re_form_shop_2605.dto.trade.TradeResponseDTO;
import com.re_form_shop_2605.dto.trade.TradeStatusRequestDTO;
import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.TradeDeliveryType;
import com.re_form_shop_2605.entity.Enum.TradeStatus;
import com.re_form_shop_2605.entity.member.Member;
import com.re_form_shop_2605.entity.trade.MannerReview;
import com.re_form_shop_2605.entity.trade.Post;
import com.re_form_shop_2605.entity.trade.PostImage;
import com.re_form_shop_2605.entity.trade.Trade;
import com.re_form_shop_2605.repository.member.MemberRepository;
import com.re_form_shop_2605.repository.trade.PostRepository;
import com.re_form_shop_2605.repository.trade.TradeRepository;
import com.re_form_shop_2605.repository.trade.mannerReviewRepository;
import com.re_form_shop_2605.repository.trade.postImageRepository;
import com.re_form_shop_2605.service.common.ServicePageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// 거래 생성, 상태 변경, 리뷰 작성 같은 거래 흐름을 담당한다.
@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final postImageRepository postImageRepository;
    private final mannerReviewRepository mannerReviewRepository;
//    private final ModelMapper modelMapper;

    @Override
    // 판매글 상태와 중복 거래 여부를 확인한 뒤 거래를 생성
    public Long addTrade(Long buyerId, TradeRequestDTO tradeRequestDTO) {
        Member buyer = memberRepository.findById(buyerId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        Post post = postRepository.findById(tradeRequestDTO.postId())
                .orElseThrow(() -> new IllegalArgumentException("판매글이 존재하지 않습니다."));

        if (post.getSellerId().getMemberId().equals(buyerId)) {
            throw new IllegalArgumentException("본인 판매글에는 거래를 생성할 수 없습니다.");
        }

        if (post.getStatus() != PostStatus.ON_SALE) {
            throw new IllegalArgumentException("판매 중인 게시글만 거래를 생성할 수 있습니다.");
        }

        if (tradeRepository.existsByPost_PostId(post.getPostId())) {
            throw new IllegalArgumentException("이미 거래가 생성된 게시글입니다.");
        }

        Trade trade = Trade.builder()
                .post(post)
                .buyer(buyer)
                .seller(post.getSellerId())
                .status(TradeStatus.REQUESTED)
                .deliveryType(toTradeDeliveryType(post.getDeliveryType()))
                .tradePrice(post.getPrice())
                .build();

        return tradeRepository.save(trade).getTradeId();
    }

    @Override
    @Transactional(readOnly = true)
    // 거래 상세 화면에 필요한 정보를 조립해 반환
    public TradeResponseDTO readTrade(Long tradeId) {
        return mapTradeResponse(getTrade(tradeId));
    }

    @Override
    @Transactional(readOnly = true)
    // 구매자 기준 거래 목록을 페이지 단위로 반환
    public PageResponse<TradeResponseDTO> readBuyerTrades(Long buyerId, int page, int size) {
        List<Trade> trades = tradeRepository.findAllByBuyer_MemberIdOrderByTradeIdDesc(buyerId);
        List<TradeResponseDTO> tradeResponseDTOList = new ArrayList<>();

        for (Trade trade : trades) {
            tradeResponseDTOList.add(mapTradeResponse(trade));
        }

        return ServicePageResponse.of(tradeResponseDTOList, page, size);
    }

    @Override
    @Transactional(readOnly = true)
    // 판매자 기준 거래 목록을 페이지 단위로 반환
    public PageResponse<TradeResponseDTO> readSellerTrades(Long sellerId, int page, int size) {
        List<Trade> trades = tradeRepository.findAllBySeller_MemberIdOrderByTradeIdDesc(sellerId);
        List<TradeResponseDTO> tradeResponseDTOList = new ArrayList<>();

        for (Trade trade : trades) {
            tradeResponseDTOList.add(mapTradeResponse(trade));
        }

        return ServicePageResponse.of(tradeResponseDTOList, page, size);
    }

    @Override
    // 요청된 거래 상태로 값을 변경
    public void modifyTradeStatus(Long tradeId, TradeStatusRequestDTO tradeStatusRequestDTO) {
        getTrade(tradeId).changeStatus(tradeStatusRequestDTO.status());
    }

    @Override
    // 거래 배송지 정보를 수정
    public void modifyDelivery(Long tradeId, DeliveryRequestDTO deliveryRequestDTO) {
        getTrade(tradeId).changeDeliveryAddress(deliveryRequestDTO.deliveryAddress());
    }

    @Override
    // 거래 완료 후 구매자만 판매자에 대한 리뷰를 남길 수 있다.
    public Long addReview(Long buyerId, ReviewRequestDTO reviewRequestDTO) {
        Trade trade = getTrade(reviewRequestDTO.tradeId());

        if (!trade.getBuyer().getMemberId().equals(buyerId)) {
            throw new IllegalArgumentException("리뷰 작성 권한이 없습니다.");
        }

        if (mannerReviewRepository.existsByTrade_TradeIdAndBuyer_MemberId(reviewRequestDTO.tradeId(), buyerId)) {
            throw new IllegalArgumentException("이미 리뷰를 작성했습니다.");
        }

        if (trade.getStatus() != TradeStatus.COMPLETED && trade.getStatus() != TradeStatus.CONFIRMED) {
            throw new IllegalArgumentException("거래 완료 후에만 리뷰를 작성할 수 있습니다.");
        }

        MannerReview review = MannerReview.builder()
                .trade(trade)
                .buyer(trade.getBuyer())
                .seller(trade.getSeller())
                .score(reviewRequestDTO.score())
                .content(reviewRequestDTO.content())
                .build();

        return mannerReviewRepository.save(review).getMannerId();
    }

    @Override
    @Transactional(readOnly = true)
    // 단건 리뷰를 화면용 DTO로 반환
    public ReviewResponseDTO readReview(Long mannerId) {
        MannerReview review = mannerReviewRepository.findById(mannerId)
                .orElseThrow(() -> new IllegalArgumentException("리뷰가 존재하지 않습니다."));
        return toReviewResponseDTO(review);
    }

    @Override
    @Transactional(readOnly = true)
    // 판매자 기준으로 받은 리뷰 목록을 페이지 단위로 반환
    public PageResponse<ReviewResponseDTO> readSellerReviews(Long sellerId, int page, int size) {
        List<MannerReview> reviews = mannerReviewRepository.findAllBySeller_MemberIdOrderByMannerIdDesc(sellerId);
        List<ReviewResponseDTO> reviewResponseDTOList = new ArrayList<>();

        for (MannerReview review : reviews) {
            reviewResponseDTOList.add(toReviewResponseDTO(review));
        }

        return ServicePageResponse.of(reviewResponseDTOList, page, size);
    }

    // 공통으로 사용하는 거래 조회 메서드
    private Trade getTrade(Long tradeId) {
        return tradeRepository.findById(tradeId)
                .orElseThrow(() -> new IllegalArgumentException("거래가 존재하지 않습니다."));
    }

    // 거래 엔티티를 화면용 응답 DTO로 조립
    private TradeResponseDTO mapTradeResponse(Trade trade) {
        List<PostImage> postImages = postImageRepository.findAllByPost_PostIdOrderBySortOrderAsc(trade.getPost().getPostId());
        String thumbnailUrl = null;
        if (!postImages.isEmpty()) {
            thumbnailUrl = postImages.get(0).getImageUrl();
        }

        boolean hasReview = mannerReviewRepository.existsByTrade_TradeIdAndBuyer_MemberId(
                trade.getTradeId(),
                trade.getBuyer().getMemberId()
        );

        PostBriefDTO postBriefDTO = new PostBriefDTO(
                trade.getPost().getPostId(),
                trade.getPost().getTitle(),
                thumbnailUrl,
                trade.getPost().getPrice(),
                trade.getPost().getStatus()
        );

        MemberBriefDTO buyer = new MemberBriefDTO(
                trade.getBuyer().getMemberId(),
                trade.getBuyer().getNickname(),
                trade.getBuyer().getProfileImageUrl()
        );
        MemberBriefDTO seller = new MemberBriefDTO(
                trade.getSeller().getMemberId(),
                trade.getSeller().getNickname(),
                trade.getSeller().getProfileImageUrl()
        );

        return new TradeResponseDTO(
                trade.getTradeId(),
                postBriefDTO,
                buyer,
                seller,
                trade.getStatus(),
                trade.getDeliveryType(),
                trade.getDeliveryAddress(),
                trade.getTradePrice(),
                trade.getCompletedAt(),
                trade.getConfirmedAt(),
                trade.getCreatedAt(),
                hasReview
        );
    }

    // 리뷰 엔티티를 화면용 응답 DTO로 변환
    private ReviewResponseDTO toReviewResponseDTO(MannerReview review) {
        MemberBriefDTO buyer = new MemberBriefDTO(
                review.getBuyer().getMemberId(),
                review.getBuyer().getNickname(),
                review.getBuyer().getProfileImageUrl()
        );
        MemberBriefDTO seller = new MemberBriefDTO(
                review.getSeller().getMemberId(),
                review.getSeller().getNickname(),
                review.getSeller().getProfileImageUrl()
        );

        return new ReviewResponseDTO(
                review.getMannerId(),
                review.getTrade().getTradeId(),
                buyer,
                seller,
                (int) Math.round(review.getScore()),
                review.getContent(),
                review.getCreatedAt()
        );
    }

    // 판매글 수령 방식 값을 거래 도메인 수령 방식 값으로 변환
    private TradeDeliveryType toTradeDeliveryType(DeliveryType deliveryType) {
        return switch (deliveryType) {
            case DIRECT -> TradeDeliveryType.DIRECT;
            case DELIVERY, BOTH -> TradeDeliveryType.DELIVERY;
        };
    }
}
