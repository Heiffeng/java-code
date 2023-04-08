package com.example.service.user.register;

import com.example.constant.RegisterType;
import com.example.request.CreateUser;
import com.example.service.user.UserQueryService;
import com.example.service.user.UserUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: Heiffeng
 * Date: 2023/4/6
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RegularUserRegisterService extends AbstractUserRegisterService{

    private final UserUpdateService userUpdateService;

    @Override
    public void checkParam(CreateUser request) {

    }

    @Override
    public void addUser(CreateUser request) {

    }

    @Override
    public void addUserRole(CreateUser request) {

    }

    @Override
    protected void sendNotifyMessage(CreateUser request) {
        log.info("普通用户注册，发送短信通知");
    }

    @Override
    protected RegisterType registerType() {
        return RegisterType.REGULAR;
    }
}
