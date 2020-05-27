package com.mygithub.restexample.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygithub.restexample.entity.User;
import com.mygithub.restexample.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author RC
 * @description 用户业务实现类
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final StringRedisTemplate redisTemplate;
	private final ObjectMapper objectMapper;
	
    @Override
    public String addUser(User user) throws Exception {
        // 直接编写业务逻辑
    	redisTemplate.opsForValue().set("user", objectMapper.writeValueAsString(user));
        return "success";
    }
    
    @Override
    public User getUserById(Long id) throws Exception {
    	String user_json = redisTemplate.opsForValue().get("user");
    	User user = objectMapper.readValue(user_json, User.class);
    	return user;
    }
    
}
