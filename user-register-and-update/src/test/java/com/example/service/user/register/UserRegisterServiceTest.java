package com.example.service.user.register;

import com.example.constant.UserType;
import com.example.request.CreateUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author: Heiffeng
 * Date: 2023/4/7
 */
@SpringBootTest
public class UserRegisterServiceTest {

    @Autowired
    private UserRegisterService userRegisterService;
    @Test
    public void test() {
        // TODO
        CreateUser request = new CreateUser();
        request.setUserType(UserType.SMS);
        userRegisterService.userRegister(request);
    }
}
