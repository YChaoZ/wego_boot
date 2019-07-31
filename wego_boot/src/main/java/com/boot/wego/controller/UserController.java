package com.boot.wego.controller;

import com.boot.wego.entity.User;
import com.boot.wego.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wego/")
public class UserController {
    @Autowired
    UserService UserService;

    // 日志文件
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "获取用户详情", notes = "")
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", dataType = "String")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable("id") String id) {
        return UserService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void updateByPrimaryKeySelective(@PathVariable("id") String id, @RequestBody User User) {
        User.setId(Integer.valueOf(id));
        int result = UserService.updateByPrimaryKeySelective(User);
        logger.debug("updateByPrimaryKeySelective result ", result);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void insertUser(@RequestBody User User) {
        int result = UserService.insertUser(User);
        logger.debug("insertUser result ", result);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User selectUserWithPassword(@RequestBody User User) {
        return UserService.selectUserWithPassword(User);
    }
}
