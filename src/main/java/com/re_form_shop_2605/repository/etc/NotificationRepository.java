package com.re_form_shop_2605.repository.etc;

import com.re_form_shop_2605.entity.etc.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByMember_MemberIdOrderByNotiIdDesc(Long memberId);

    int countByMember_MemberIdAndIsReadFalse(Long memberId);
}
