package com.re_form_shop_2605.repository.trade;

import com.re_form_shop_2605.entity.trade.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface postImageRepository  extends JpaRepository<PostImage,Long> {
    List<PostImage> findAllByPost_PostIdOrderBySortOrderAsc(Long postId);

    void deleteByPost_PostId(Long postId);
}
