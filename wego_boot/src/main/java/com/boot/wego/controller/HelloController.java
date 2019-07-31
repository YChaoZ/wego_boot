package com.boot.wego.controller;

import com.boot.wego.entity.property.HomePeoperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    HomePeoperty homePeoperty;
    @RequestMapping("/")
    public String sayHello(ModelMap modelMap){
        modelMap.addAttribute("province",homePeoperty.getProvince());
        modelMap.addAttribute("city",homePeoperty.getCity());
        modelMap.addAttribute("desc",homePeoperty.getDesc());
        return "hello";
    }
}
