package com.itbank.crud01.interceptor;

import com.itbank.crud01.model.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Member login = (Member) session.getAttribute("login");
        if(login == null) {
            System.out.println("preHandle 동작 테스트");
            response.sendRedirect("/");
            return false;
        }
        System.out.println("preHandle 동작 테스트");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
