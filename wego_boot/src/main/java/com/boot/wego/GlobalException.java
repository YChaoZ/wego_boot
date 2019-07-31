package com.boot.wego;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpRequest request, Exception e){
        // TODO 尚未解决统一问题，无法获取错误e等值. defaultException未覆盖
        ModelAndView modelAndView = new ModelAndView();

        // 获取请求内容和请求错误，并统一返回错误页面
        modelAndView.addObject("errorPage","统一请求错误页面");
        modelAndView.addObject("url",request.getURI());
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("globalError");

        return modelAndView;
    }
}
