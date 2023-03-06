package com.arthurtien.springbootmall.dao;

import com.arthurtien.springbootmall.dto.UserRegisterRequest;
import com.arthurtien.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
