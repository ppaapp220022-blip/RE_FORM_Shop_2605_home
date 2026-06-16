package com.re_form_shop_2605.controller.admin;

import com.re_form_shop_2605.entity.trade.Post;
import com.re_form_shop_2605.repository.trade.PostRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "관리자 API", description = "임베딩")
public class PostEmbeddingAdminController {

    private final PostRepository postRepository;
    private final ObjectProvider<VectorStore> vectorStoreProvider;

    @PostMapping("/admin/embed/posts")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> embedAllExistingPosts() {
        VectorStore vectorStore = vectorStoreProvider.getIfAvailable();
        if (vectorStore == null) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("벡터 스토어가 비활성화되어 임베딩을 실행할 수 없습니다.");
        }

        int page = 0, size = 100, totalEmbedded = 0;
        while (true) {
            List<Post> batch = postRepository.findAll(PageRequest.of(page++, size)).getContent();
            if (batch.isEmpty()) break;
            for (Post post : batch) {
                try {
                    String content = String.join(" ",
                            post.getSport() != null ? post.getSport().name() : "",
                            post.getTeam() != null ? post.getTeam() : "",
                            post.getUniformName() != null ? post.getUniformName() : "",
                            post.getTitle() != null ? post.getTitle() : "",
                            post.getContent() != null
                                    ? post.getContent().substring(0, Math.min(post.getContent().length(), 300))
                                    : ""
                    ).trim();

                    Document doc = new Document(
                            "postId-" + post.getPostId(),
                            content,
                            Map.of(
                                    "postId", post.getPostId().toString(),
                                    "sport",  post.getSport() != null ? post.getSport().name() : "",
                                    "team",   post.getTeam() != null ? post.getTeam() : ""
                            )
                    );
                    vectorStore.add(List.of(doc));
                    totalEmbedded++;
                } catch (Exception e) {
                    // 개별 실패는 무시하고 계속
                }
            }
        }
        return ResponseEntity.ok("임베딩 완료: " + totalEmbedded + "건");
    }
}
