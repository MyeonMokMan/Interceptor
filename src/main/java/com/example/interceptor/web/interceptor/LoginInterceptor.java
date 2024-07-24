package com.example.interceptor.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final String LOG_ID = "LOG_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        // true: 세션이 없으면 새로 생성. false: 세션이 없으면 생성 안함
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("loginSuccess") == null) {
            log.info("미인증 사용자 요청");

            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
