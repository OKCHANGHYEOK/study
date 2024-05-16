package com.itbank.crud01.interceptor;

import com.itbank.crud01.model.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Member login = (Member) session.getAttribute("login");
        if(login == null) {
            response.sendRedirect("/alert");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
