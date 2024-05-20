package com.itbank.crud01.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(BadWritingTryException.class)
    public ModelAndView BadWritingTryExceptionHandler(BadWritingTryException e) {
        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "그러한 작성은 허용되지 않습니다!");
        return mav;
    }

    @ExceptionHandler(BadAccessException.class)
    public ModelAndView BadAccessExceptionHandler(BadAccessException e) {
        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "잘못된 접근입니다");
        return mav;
    }

    @ExceptionHandler(NoSuchBoardException.class)
    public ModelAndView NoSuchBoardExceptionHandler(NoSuchBoardException e) {
        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "존재하지 않는 게시글입니다");
        return mav;
    }
}
