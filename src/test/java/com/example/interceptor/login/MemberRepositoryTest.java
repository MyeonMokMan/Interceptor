package com.example.interceptor.login;

import com.example.interceptor.domain.member.Member;
import com.example.interceptor.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class MemberRepositoryTest {

    private MemberRepository memberRepository = new MemberRepository();

    @Test
    void loginTest() {
        Member member = memberRepository.loginCheck("onisic", "0000");
        Assertions.assertThat(member).isNull();
    }
}
