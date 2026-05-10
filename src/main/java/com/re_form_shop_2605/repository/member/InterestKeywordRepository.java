package com.re_form_shop_2605.repository.member;

import com.re_form_shop_2605.entity.member.InterestKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestKeywordRepository extends JpaRepository<InterestKeyword, Long> {
    List<InterestKeyword> findAllByMember_MemberId(Long memberId);

    void deleteByMember_MemberId(Long memberId);
}
