package com.re_form_shop_2605.mapper.chat;

import com.re_form_shop_2605.domain.chat.ChatMessageVO;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ─────────────────────────────────────────────────────
 * 작성자: 진혜림
 * 작성일: 2026-05-14
 * 설명: 채팅방 Mapper
 * ─────────────────────────────────────────────────────
 */
public interface ChatMessageMapper {
    /**
     * 채팅방 메시지 목록 조회
     *
     * @param chatId: 채팅방 PK
     * @param offset: 시작 행 번호 (page * size)
     * @param size: 페이지 크기
     */
    List<ChatMessageVO> findMessagesWithModeration(@Param("chatId") Long chatId, @Param("offset") int offset, @Param("size") int size);

    /* 채팅방 전체 메시지 수 */
    int countMessagesByChatId(@Param("chatId") Long chatId);
}
