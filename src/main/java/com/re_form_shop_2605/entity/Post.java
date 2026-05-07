package com.re_form_shop_2605.entity;

import com.re_form_shop_2605.entity.Enum.DeliveryType;
import com.re_form_shop_2605.entity.Enum.Grade;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.Sport;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; // 게시글 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Member sellerId; // 판매자 member id

    @Column(length = 200)
    private String title; // 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // 본문

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sport sport; // 구단명

    @Column(length = 200, nullable = false)
    private String uniformName; // 유니폼명

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade; // 유니폼 상태 등급

    @Column(length = 10)
    private String size; // 유니폼 사이즈 (85 ~120)

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean marking; // 마킹 여부

    @Column(nullable = false)
    private int price; // 희망 가격

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryType deliveryType; // 수령 방법

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "", nullable = false)
    private PostStatus status;

    /*
    status        ENUM ('ON_SALE', 'RESERVED', 'SOLD', 'HIDDEN', 'DELETED')          NOT NULL DEFAULT 'ON_SALE' COMMENT '거래 상태',
    view_count    INT                                                                NOT NULL DEFAULT 0 COMMENT '조회수',
    wish_count    INT                                                                NOT NULL DEFAULT 0 COMMENT '찜 수',
    risk_level    ENUM ('LOW', 'MID', 'HIGH')                                        NULL COMMENT '위험 탐지 등급',
    created_at    DATETIME                                                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시글 등록일',
    updated_at    DATETIME                                                           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '게시글 수정일',
    KEY idx_post_seller_id (seller_id),
    KEY idx_post_status (status),
    CONSTRAINT fk_post_member FOREIGN KEY (seller_id) REFERENCES member (member_id)
     */
}
