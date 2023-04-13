package com.example.service.user.register;

import com.example.constant.RegisterType;
import com.example.constant.UserType;
import com.example.request.CreateUser;
import com.example.response.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户注册策略实现类
 * Author: Heiffeng
 * Date: 2023/4/6
 */
@Service
@RequiredArgsConstructor
public class UserRegisterService {

    private final List<AbstractUserRegisterService> registerServiceList;

    // 根据UserType获取对应的注册策略
    public AbstractUserRegisterService getRegisterService(UserType userType) {
        RegisterType registerType = RegisterType.getRegisterType(userType);
        List<AbstractUserRegisterService> registerServices = registerServiceList.stream()
                .filter(registerService -> registerService.registerType().equals(registerType))
                .collect(Collectors.toList());
        if (registerServices.size() > 0) {
            return registerServices.get(0);
        }
        return null;
    }


    public CreateUserResponse userRegister(CreateUser request) {
        AbstractUserRegisterService service = getRegisterService(request.getUserType());
        return service.register(request);
    }

}
