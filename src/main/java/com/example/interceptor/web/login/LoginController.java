package com.example.interceptor.web.login;

import com.example.interceptor.domain.member.Member;
import com.example.interceptor.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("member") Member member) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("member") Member member, HttpServletRequest request) {

        log.info("로그인 컨트롤러...");
        Member loginMember = memberRepository.loginCheck(member.getLoginId(), member.getPassword());

        if(loginMember == null) {
            return "login/loginForm";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute("loginSuccess", loginMember);

        return "redirect:loginSuccess";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "login/loginSuccess";
    }


}
