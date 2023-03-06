package com.arthurtien.springbootmall.service.impl;

import com.arthurtien.springbootmall.dao.UserDao;
import com.arthurtien.springbootmall.dto.UserRegisterRequest;
import com.arthurtien.springbootmall.model.User;
import com.arthurtien.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
