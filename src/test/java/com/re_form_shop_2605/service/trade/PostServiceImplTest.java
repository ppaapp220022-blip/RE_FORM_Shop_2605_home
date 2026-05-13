package com.re_form_shop_2605.service.trade;

import com.re_form_shop_2605.domain.trade.PostCardVO;
import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.trade.PostCardDTO;
import com.re_form_shop_2605.dto.trade.PostDetailDTO;
import com.re_form_shop_2605.dto.trade.PostRequestDTO;
import com.re_form_shop_2605.dto.trade.PostUpdateRequestDTO;
import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.Grade;
import com.re_form_shop_2605.entity.Enum.MemberStatus;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.Role;
import com.re_form_shop_2605.entity.Enum.Sport;
import com.re_form_shop_2605.entity.member.Member;
import com.re_form_shop_2605.entity.trade.Post;
import com.re_form_shop_2605.repository.member.MemberRepository;
import com.re_form_shop_2605.repository.trade.PostRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@SpringBootTest
//@Transactional
class PostServiceImplTest {

    @Autowired
    private PostService postService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostVectorService postVectorService;

    @Test
    void addPostTest() {
        Member seller = createSeller("add_post");
        Long postId = postService.addPost(seller.getMemberId(), createPostRequestDTO("add title"), List.of());

        assertNotNull(postId);
    }

    @Test
    void readPostTest() {
        Member seller = createSeller("read_post");
        Long postId = postService.addPost(seller.getMemberId(), createPostRequestDTO("read title"), List.of());

        PostDetailDTO postDetailDTO = postService.readPost(postId, null);

        assertEquals("read title", postDetailDTO.title());
        assertEquals(PostStatus.ON_SALE, postDetailDTO.status());
    }

    @Test
    void readAllPostsTest() {
        Member seller = createSeller("all_post");
        String titlePrefix = "bulk_title_" + System.nanoTime() + "_";
        for (int i = 0; i < 10; i++) {
            postService.addPost(seller.getMemberId(), createPostRequestDTO(titlePrefix + i), List.of());
        }

        PageResponse<PostCardDTO> posts = postService.readAllPosts(null, 0, 10000);
        int matchedCount = 0;

        for (PostCardDTO post : posts.content()) {
            if (post.title().startsWith(titlePrefix)) {
                matchedCount++;
            }
        }

        assertEquals(10, matchedCount);
    }

    @Test
    void modifyPostTest() {
        Member seller = createSeller("modify_post");
        Long postId = postService.addPost(seller.getMemberId(), createPostRequestDTO("origin title"), List.of());

        PostUpdateRequestDTO requestDTO = new PostUpdateRequestDTO(
                "updated title",
                "updated content",
                Grade.S,
                "105",
                false,
                12000,
                DeliveryType.DELIVERY
        );

        postService.modifyPost(postId, seller.getMemberId(), requestDTO, null);

        PostDetailDTO postDetailDTO = postService.readPost(postId, null);
        assertEquals("updated title", postDetailDTO.title());
        assertEquals(12000, postDetailDTO.price());
        assertEquals(Grade.S, postDetailDTO.grade());
    }

    @Test
    void removePostTest() {
        Member seller = createSeller("remove_post");
        Long postId = postService.addPost(seller.getMemberId(), createPostRequestDTO("remove title"), List.of());

        postService.removePost(postId, seller.getMemberId());

        assertEquals(PostStatus.DELETED, postRepository.findById(postId).orElseThrow().getStatus());
    }

    private Member createSeller(String prefix) {
        long seed = System.nanoTime();
        Member seller = Member.builder()
                .email(prefix + "_" + seed + "@test.com")
                .password("1234")
                .nickname(prefix + "_" + seed)
                .mannerScore(BigDecimal.ZERO)
                .role(Role.USER)
                .status(MemberStatus.ACTIVE)
                .warningCount(0)
                .emailEvent(false)
                .build();
        return memberRepository.save(seller);
    }

    private PostRequestDTO createPostRequestDTO(String title) {
        return new PostRequestDTO(
                title,
                "테스트 본문",
                Sport.BASEBALL,
                "LG",
                "유니폼",
                Grade.A,
                "100",
                false,
                10000,
                DeliveryType.DIRECT
        );
    }

    @Test
    void testSearchPosts() {
        String keyword = null;
        Sport sport = Sport.BASEBALL;
        int page = 0;
        int size = 10;

        PageResponse<PostCardDTO> response = postService.searchPosts(
                keyword, sport, null, null, null, null,
                "latest", page, size, null
        );

        log.info("조회된 게시글 수 : " + response.content().size());
        log.info("전체 게시글 수 : " + response.totalElements());

        assertThat(response.content()).isNotNull();

        if (response.totalElements() > 0) {
            assertThat(response.content().get(0).sport()).isEqualTo(Sport.BASEBALL);
            assertThat(response.content().get(0).seller()).isNotNull();
        }
    }

    @Test
    void initPostVectors() {
        List<Post> posts = postRepository.findAllByStatusNotIn(List.of(PostStatus.DELETED, PostStatus.HIDDEN));
        log.info("전체 게시글 수: {}", posts.size());

        for (Post post : posts) {
            try {
                postVectorService.savePostVector(post);
            } catch (Exception e) {
                log.error("벡터 저장 실패 : postId: {} | {}", post.getPostId(), e.getMessage());
            }
        }
        log.info("벡터 저장 완료");
    }
}
