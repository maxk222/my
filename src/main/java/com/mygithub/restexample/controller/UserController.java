package com.mygithub.restexample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.mygithub.restexample.enetity.User;
import com.mygithub.restexample.service.UserService;

import javax.validation.Valid;

/**
 * @author RC
 * @description 用户接口
 */
@RestController
@Api(tags = "用户接口")
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final StringRedisTemplate redisTemplate;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) throws Exception {
        return userService.addUser(user);
    }

    @ApiOperation("获得单个用户")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")Long id) throws Exception {
    	User user = userService.getUserById(id);
        return user;
    }

}
