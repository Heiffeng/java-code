package com.example.constant;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Heiffeng
 * Date: 2023/4/6
 */
public enum RegisterType {

    REGULAR(1,"REGULAR", Arrays.asList(UserType.SALES)),
    SMS(2,"SMS", Arrays.asList(UserType.SMS)),
    ;

    public Integer code;
    public String name;
    public List<UserType> userTypes;

    RegisterType(Integer code, String name, List<UserType> userTypes) {
        this.code = code;
        this.name = name;
        this.userTypes = userTypes;
    }

    public static RegisterType getRegisterType(UserType userType) {
        for (RegisterType value : RegisterType.values()) {
            if (value.userTypes.contains(userType)) {
                return value;
            }
        }
        return null;
    }
}
