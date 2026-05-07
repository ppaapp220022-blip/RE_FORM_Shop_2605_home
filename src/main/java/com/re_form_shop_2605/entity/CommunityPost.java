package com.re_form_shop_2605.entity;

import com.re_form_shop_2605.entity.Enum.SportCategory;
import com.re_form_shop_2605.entity.Enum.CommunityPostStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member memberId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SportCategory sportCategory; // 종목

    @Column(length = 50)
    private String teamCategory; // 구단명

    @Column(length = 200, nullable = false)
    private String commTitle ; // 제목

    @Column(columnDefinition = "TEXT")
    private String commContent; // 본문

    @Column(length = 500)
    private String commImageUrl; // 첨부 이미지 URL

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private int commViewCount = 0; // 조회수

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private int likeCount = 0; // 좋아요 수

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private int commentCount; // 댓글 수

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommunityPostStatus status; // 게시글 상태
}
