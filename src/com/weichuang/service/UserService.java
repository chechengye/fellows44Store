package com.weichuang.service;

import com.weichuang.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    int registerUser(User user , String[] hobbies);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
