package com.weichuang.web.service;

import com.weichuang.web.pojo.User;

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

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    int checkUserNameIsExist(String userName);
}
