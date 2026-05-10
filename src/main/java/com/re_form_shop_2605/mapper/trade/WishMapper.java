package com.re_form_shop_2605.mapper.trade;

import com.re_form_shop_2605.domain.trade.WishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WishMapper {
    // 회원 번호와 게시글 번호 기준 찜 단건 조회
    WishVO findWishByMemberIdAndPostId(@Param("memberId") Long memberId, @Param("postId") Long postId);
}
