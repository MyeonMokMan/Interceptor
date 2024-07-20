package com.example.interceptor.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    public Member save(Member member) {
        store.put(member.getLoginId(),member);
        return member;
    }

    /*
    * 간단히 구현
    */
    public Member loginCheck(String id, String password) {

        if(store.get(id) == null) {
            return null;
        }

        return store.get(id).getPassword().equals(password) ? store.get(id) : null;
    }
}
