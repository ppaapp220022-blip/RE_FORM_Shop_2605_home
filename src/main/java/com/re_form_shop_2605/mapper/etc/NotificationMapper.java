package com.re_form_shop_2605.mapper.etc;

import com.re_form_shop_2605.domain.etc.NotificationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotificationMapper {
    // 회원 번호 기준 전체 알림 목록 조회
    List<NotificationVO> findNotificationsByMemberId(@Param("memberId") Long memberId);

    // 읽음 여부 수정
    int updateReadStatus(@Param("notiId") Long notiId, @Param("isRead") boolean isRead);

    // 알림 번호 기준 삭제
    int deleteNotification(@Param("notiId") Long notiId);

}
