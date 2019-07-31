package com.boot.wego.service.impl;

import com.boot.wego.dao.mapper.UserMapper;
import com.boot.wego.entity.User;
import com.boot.wego.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int insertUser(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectUserWithPassword(User record) {
        return null;
    }

    @Override
    public User selectByPrimaryKey(String id) {
        // 从缓存中获取key信息
        String key = "user_" + id;

        // 先从redis中获取，redis中不存在再获取数据库信息
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            logger.info("UserServiceImpl.selectByPrimaryKey():从缓存中获取用户" + id + "信息。");
            return user;
        }

        // 数据库获取用户信息，并保存到redis
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(id));
        redisTemplate.opsForValue().set(key, user, 10, TimeUnit.SECONDS);
        logger.info("UserServiceImpl.selectByPrimaryKey():从数据库中获取用户" + id + "信息。");
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
