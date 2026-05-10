package com.re_form_shop_2605.service.etc;

import com.re_form_shop_2605.dto.common.PageResponse;
import com.re_form_shop_2605.dto.etc.NotificationDTO;
import com.re_form_shop_2605.dto.etc.NotificationResponseDTO;
import com.re_form_shop_2605.entity.etc.Notification;
import com.re_form_shop_2605.repository.etc.NotificationRepository;
import com.re_form_shop_2605.service.common.ServicePageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;

    @Override
    // 알림 목록과 읽지 않은 개수를 함께 반환
    public NotificationResponseDTO readNotifications(Long memberId, int page, int size) {
        List<Notification> notifications = notificationRepository.findAllByMember_MemberIdOrderByNotiIdDesc(memberId);
        List<NotificationDTO> items = new ArrayList<>();

        for (Notification notification : notifications) {
            items.add(toNotificationDTO(notification));
        }

        int unreadCount = notificationRepository.countByMember_MemberIdAndIsReadFalse(memberId);
        PageResponse<NotificationDTO> pageResponse = ServicePageResponse.of(items, page, size);
        return new NotificationResponseDTO(pageResponse, unreadCount);
    }

    @Override
    // 알림을 읽음 상태로 변경
    public void modifyNotificationRead(Long notiId) {
        Notification notification = notificationRepository.findById(notiId)
                .orElseThrow(() -> new IllegalArgumentException("알림이 존재하지 않습니다."));
        notification.read();
    }

    @Override
    // 알림 삭제
    public void removeNotification(Long notiId) {
        notificationRepository.deleteById(notiId);
    }

    // 알림 엔티티를 응답 DTO로 변환
    private NotificationDTO toNotificationDTO(Notification notification) {
        return new NotificationDTO(
                notification.getNotiId(),
                notification.getType(),
                notification.getReportContent(),
                notification.getLinkUrl(),
                notification.isRead(),
                notification.getCreatedAt()
        );
    }
}
