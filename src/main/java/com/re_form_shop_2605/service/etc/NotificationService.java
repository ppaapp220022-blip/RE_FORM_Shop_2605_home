package com.re_form_shop_2605.service.etc;

import com.re_form_shop_2605.dto.etc.NotificationResponseDTO;

// 알림 서비스 인터페이스
public interface NotificationService {
    // 알림 목록을 조회
    NotificationResponseDTO readNotifications(Long memberId, int page, int size);

    // 알림을 읽음 상태로 변경
    void modifyNotificationRead(Long notiId);

    // 알림을 삭제
    void removeNotification(Long notiId);
}
