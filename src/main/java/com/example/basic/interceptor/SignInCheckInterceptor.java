package com.example.basic.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SignInCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        log.debug("preHandle");
        HttpSession session = request.getSession();

        // 수정: 직접 캐스팅 대신 String.valueOf() 사용
        Object userObj = session.getAttribute("user");

        // userObj가 null이거나, String으로 변환했을 때 "null" 문자열이 되는 경우를 체크
        if (userObj == null) {
            response.sendRedirect("/login");
            return false;
        }

        String user = String.valueOf(userObj);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("postHandle");
    }

}
