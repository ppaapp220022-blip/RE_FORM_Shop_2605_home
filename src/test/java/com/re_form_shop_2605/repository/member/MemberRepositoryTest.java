package com.re_form_shop_2605.repository.member;

import com.re_form_shop_2605.entity.Enum.MemberStatus;
import com.re_form_shop_2605.entity.Enum.Role;
import com.re_form_shop_2605.entity.member.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Test
    void insert() {
        Member  member = Member.builder()
                .email("123@gmail.com")
                .password("1234")
                .nickname("tom")
                .profileImageUrl("https://avatars.githubusercontent.com/u/2605?v=4")
                .bio("Hi")
                .mannerScore(BigDecimal.valueOf(2))
                .role(Role.USER)
                .status(MemberStatus.ACTIVE)
                .warningCount(0)
                .emailEvent(true)
                .build();
        memberRepository.save(member);
    }

    @Test
    void findById() {
        Member member = memberRepository.findById(2L).get();
    }

}