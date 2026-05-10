package com.re_form_shop_2605.service.trade;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.trade.PostCardDTO;
import com.re_form_shop_2605.dto.trade.PostDetailDTO;
import com.re_form_shop_2605.dto.trade.PostRequestDTO;
import com.re_form_shop_2605.dto.trade.PostUpdateRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 판매글 관련 서비스 인터페이스
public interface PostService {
    // 판매글 이미지 함께 등록
    Long addPost(Long sellerId, PostRequestDTO postRequestDTO, List<MultipartFile> images);

    // 판매글 상세 정보 조회
    PostDetailDTO readPost(Long postId, Long viewerId);

    // 판매글 목록을 페이지 단위 조회
    PageResponse<PostCardDTO> readAllPosts(Long viewerId, int page, int size);

    // 판매글 이미지 수정
    void modifyPost
    (Long postId, Long sellerId, PostUpdateRequestDTO postUpdateRequestDTO, List<MultipartFile> images);

    // 판매글 삭제 상태로 변경
    void removePost(Long postId, Long sellerId);
}
