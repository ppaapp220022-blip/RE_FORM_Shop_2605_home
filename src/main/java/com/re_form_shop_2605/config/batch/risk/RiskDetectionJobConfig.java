package com.re_form_shop_2605.config.batch.risk;

import com.re_form_shop_2605.dto.AI.RiskAnalysisResultDTO;
import com.re_form_shop_2605.dto.AI.RiskDetectionResultDTO;
import com.re_form_shop_2605.entity.Enum.PostStatus;
import com.re_form_shop_2605.entity.Enum.ReportTargetType;
import com.re_form_shop_2605.entity.Enum.RiskLevel;
import com.re_form_shop_2605.entity.Enum.TargetType;
import com.re_form_shop_2605.entity.trade.Post;
import com.re_form_shop_2605.repository.etc.ReportRepository;
import com.re_form_shop_2605.repository.trade.PostRepository;
import com.re_form_shop_2605.service.AI.ModerationService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 손민정
 * 작성일: 2026-05-14
 * 설명: 게시물 위험 재탐지 검사
 *      - 미검사 게시글 위험 재탐지
 *      - 누적 신고 3건 이상 게시글 위험 재탐지
 * ─────────────────────────────────────────────────────
 */

@Configuration
@RequiredArgsConstructor
public class RiskDetectionJobConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final PostRepository postRepository;
    private final ReportRepository reportRepository;
    private final ModerationService moderationService;

    // 1. JOB
    @Bean
    public Job riskDetectionJob() {
        return new JobBuilder("riskDetectionJob", jobRepository)
                .start(riskDetectionStep())
                .build();
    }

    // 2. Step
    @Bean
    public Step riskDetectionStep() {
        return new StepBuilder("riskDetectionStep", jobRepository)
                .<Post, RiskDetectionResultDTO>chunk(10)
                .transactionManager(platformTransactionManager)
                .reader(new ItemReader<Post>() {
                    // 대상 Post 조회
                    private List<Post> posts;
                    private int index;

                    @Override
                    public @Nullable Post read() throws Exception {
                        if (posts == null) {
                            // 미검사 게시글 조회
                            List<Post> unchecked = postRepository.findAllByRiskLevelIsNullAndStatusNotIn(
                                    List.of(PostStatus.HIDDEN, PostStatus.DELETED)
                            );

                            // 누적 신고 3건 이상 게시글 조회
                            List<Long> overReportedIds = reportRepository.findTargetIdsWithReportCountOver(ReportTargetType.POST);
                            List<Post> overReportedPosts = postRepository.findAllById(overReportedIds);

                            // 조회된 게시글 통합 (중복 제거)
                            Set<Long> set = new HashSet<>();
                            posts = new ArrayList<>();
                            for (Post post : unchecked) {
                                if (set.add(post.getPostId())) posts.add(post);
                            }
                            for (Post post : overReportedPosts) {
                                if (set.add(post.getPostId())) posts.add(post);
                            }
                        }
                        return index < posts.size() ? posts.get(index++) : null;
                    }
                })
                .processor(riskDetectionProcess()) // AI 분석 후 RiskDetectionResultDTO 반환
                .writer(saveRiskDetectionResult()) // Post riskLevel 업데이트 및 HIGH 등급 관리자 검토 등록
                .build();
    }

    // 3. ItemProcessor
    @Bean
    public ItemProcessor<Post, RiskDetectionResultDTO> riskDetectionProcess() {
        return post -> {
            String contentToCheck = ((post.getTitle() == null ? "" : post.getTitle().trim()) + " "
                    + (post.getContent() == null ? "" : post.getContent().trim())).trim();
            RiskAnalysisResultDTO riskAnalysisResultDTO = moderationService.checkAndSave(
                    contentToCheck,
                    TargetType.POST,
                    post.getPostId()
            );

            return new RiskDetectionResultDTO(post, riskAnalysisResultDTO);
        };
    }

    // 5. ItemWriter
    @Bean
    public ItemWriter<RiskDetectionResultDTO> saveRiskDetectionResult() {
        return chunk -> {
            for (RiskDetectionResultDTO dto : chunk.getItems()) {
                RiskAnalysisResultDTO riskAnalysisResult = dto.riskAnalysisResultDTO();

                if (riskAnalysisResult.riskLevel() == null) continue;

                Post post = dto.post();
                post.updateRiskLevel(riskAnalysisResult.riskLevel());
                postRepository.save(post);
            }
        };
    }
}
