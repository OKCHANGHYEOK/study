package com.itbank.crud01.controller;

import com.itbank.crud01.model.Member;
import com.itbank.crud01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService ms;

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    public ModelAndView join(Member member) {
        ModelAndView mav = new ModelAndView("home");
        try {
            ms.join(member);
        } catch (Exception e) {
            mav.addObject("msg", "가입 실패");
            mav.setViewName("alert");
            return mav;
        }
        return mav;
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(Member member, HttpSession session) {
        Member login = ms.login(member);
        if(login != null) {
            System.out.println(login.getUsername());
            session.setAttribute("login", login);
        }
        return "home";
    }
}
