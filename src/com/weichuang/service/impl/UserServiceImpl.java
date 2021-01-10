package com.weichuang.service.impl;

import com.weichuang.dao.UserDao;
import com.weichuang.pojo.User;
import com.weichuang.service.UserService;

import java.util.Arrays;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDao();
    }
    @Override
    public int registerUser(User user , String[] hobbies) {
        String hobby = Arrays.toString(hobbies);//[篮球,足球,乒乓球]
        //处理完毕复选结果之后进行重新赋值
        user.setHobby(hobby.substring(1 , hobby.length()-1));
        //不重复的随机串获取 shagshaghs-ewtyetyw-dhsjhdjs-dhsjhdjs
        System.out.println("uuid length = " + UUID.randomUUID().toString());
        user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
        return userDao.registerUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username , password);
    }
}
