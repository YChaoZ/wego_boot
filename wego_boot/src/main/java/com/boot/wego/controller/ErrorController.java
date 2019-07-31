package com.boot.wego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {
    @RequestMapping(value = "/")
    public String error() throws Exception {
        throw new Exception("错误测试");
    }
}
