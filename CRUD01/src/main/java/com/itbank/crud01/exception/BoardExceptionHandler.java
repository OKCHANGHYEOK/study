package com.itbank.crud01.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(BadWritingTryException.class)
    public ModelAndView handleBadWritingTryException(BadWritingTryException e) {
        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "그러한 작성은 허용되지 않습니다!");
        return mav;
    }
}
