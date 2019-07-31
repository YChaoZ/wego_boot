package com.boot.wego.service;

import com.boot.wego.entity.User;

public interface UserService {
    int insertUser(User record);

    User selectUserWithPassword(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);
}
