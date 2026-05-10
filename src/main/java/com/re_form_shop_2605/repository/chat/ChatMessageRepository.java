package com.re_form_shop_2605.repository.chat;

import com.re_form_shop_2605.entity.chat.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // 채팅방 메시지 이력 페이징 조회
    Page<ChatMessage> findByChatRoom_ChatIdOrderByCreatedAtDesc(Long chatId, Pageable pageable);
}
