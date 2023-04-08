package com.example.constant;

/**
 * Author: Heiffeng
 * Date: 2023/4/6
 */
public enum UserType {

    SALES(1,"SALES"),
    TOC(2,"TOC"),
    TOB(3,"TOB"),
    SMS(4,"SMS");

    public Integer code;
    public String name;

    UserType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
