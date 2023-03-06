package com.arthurtien.springbootmall.controller;


import com.arthurtien.springbootmall.dto.UserRegisterRequest;
import com.arthurtien.springbootmall.model.User;
import com.arthurtien.springbootmall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user/register")
  public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {

    // 創建帳號, 返回userId
    Integer userId = userService.register(userRegisterRequest);

    // 用userId查詢帳號數據
    User user = userService.getUserById(userId);

    // 將創建的數據傳回前端
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
