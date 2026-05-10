package com.re_form_shop_2605.repository.trade;

import com.re_form_shop_2605.entity.trade.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
    boolean existsByMember_MemberIdAndPost_PostId(Long memberId, Long postId);
}
