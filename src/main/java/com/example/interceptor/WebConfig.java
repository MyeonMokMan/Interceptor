package com.example.interceptor;

import com.example.interceptor.web.interceptor.LogInterceptor;
import com.example.interceptor.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    * 인터셉터 등록
    * 1. 로그 인터셉트 (정적 리소스, 에러 페이지 접근시 로그 제외)
    * 2. 로그인 체크 인터셉트 (정적 리소스, 에러 페이지, 로그인 페이지 제외)
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");
        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/css/**", "/*.ico", "/error");

    }
}
