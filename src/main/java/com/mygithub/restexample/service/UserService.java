package com.mygithub.restexample.service;

import com.mygithub.restexample.enetity.User;

/**
 * @author RudeCrab
 * @description 用户业务接口
 */
public interface UserService {
    /**
     *
     * @param user 用户对象
     * @return 成功则返回"success"，失败则返回错误信息
     * @throws Exception 
     */
    String addUser(User user) throws Exception;

	User getUserById(Long id) throws Exception;
}
