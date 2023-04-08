package com.example.request;

import com.example.constant.UserType;
import lombok.Data;

/**
 * Author: Heiffeng
 * Date: 2023/4/6
 */
@Data
public class CreateUser {

    private String userName;

    private String password;

    private String email;

    private String phone;

    private UserType userType;
}
