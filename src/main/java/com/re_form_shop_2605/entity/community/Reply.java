package com.re_form_shop_2605.entity.community;

import com.re_form_shop_2605.entity.BaseEntity;
import com.re_form_shop_2605.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false)
    private Long replyId; // 댓글 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private CommunityPost communityPost; // 커뮤니티 게시글 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 작성자 member_id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Reply reply; // 대댓글의 부모 댓글

    @Column(columnDefinition = "TEXT")
    private String replyContent; // 댓글 내용

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
    private Boolean isDeleted = false; // 삭제 여부 (soft delete)

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private int likeCount = 0; // 좋아요 수

    @OneToMany(mappedBy = "reply")
    private List<Reply> replies = new ArrayList<>();
}
