package com.arthurtien.springbootmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer userId;

//    @JsonProperty("e_mail") // 回傳前端的json 的 email key 變成 e_mail
    private String email;

    @JsonIgnore
    private String password;

    private Date createDate;
    private Date lastModifiedDate;
}
