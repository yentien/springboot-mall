package com.arthurtien.springbootmall.service;

import com.arthurtien.springbootmall.dto.UserLoginRequest;
import com.arthurtien.springbootmall.dto.UserRegisterRequest;
import com.arthurtien.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
