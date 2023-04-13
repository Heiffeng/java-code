package com.example.service.user.register;

import com.example.constant.RegisterType;
import com.example.request.CreateUser;
import com.example.response.CreateUserResponse;
import com.example.service.user.UserQueryService;
import lombok.RequiredArgsConstructor;

/**
 * 用户注册模板类
 * Author: Heiffeng
 * Date: 2023/4/6
 */
public abstract class AbstractUserRegisterService {

    private UserQueryService userQueryService;

    public void setUserQueryService(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    public CreateUserResponse register(CreateUser request) {
        // 校验参数
        checkParam(request);
        // 添加用户
        addUser(request);
        // 添加用户角色
        addUserRole(request);
        // 添加用户权限

        // 添加用户组织

        // 添加用户角色组织关系

        // 发送通知消息
        sendNotifyMessage(request);
        // 返回结果
        return new CreateUserResponse();
    }

    protected void checkParam(CreateUser request){
        if(userQueryService.existUser(request.getUserName())){
            throw new RuntimeException("用户已存在");
        }
    }

    protected abstract void addUser(CreateUser request);

    protected abstract void addUserRole(CreateUser request);

    protected abstract void sendNotifyMessage(CreateUser request);

    protected abstract RegisterType registerType();
}
