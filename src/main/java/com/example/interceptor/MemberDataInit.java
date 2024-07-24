package com.example.interceptor;

import com.example.interceptor.domain.member.Member;
import com.example.interceptor.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberDataInit {

    private final MemberRepository memberRepository;

    /*
    * 테스트 데이터 추가
    */
    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("0000");

        memberRepository.save(member);
    }
}
