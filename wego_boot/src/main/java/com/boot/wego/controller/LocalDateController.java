package com.boot.wego.controller;

import com.boot.wego.util.UserLocalDate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalDateController {
    @RequestMapping(value = "/localDate",method = RequestMethod.POST)
    public UserLocalDate userLocalDate(@RequestBody UserLocalDate userLocalDate){
        return userLocalDate;
    }
}