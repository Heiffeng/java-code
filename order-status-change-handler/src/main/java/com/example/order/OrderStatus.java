package com.example.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/4/21 18:25
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

    WAITING_PAY(0,"等待支付"),
    WAITING_SEND(1,"待发货"),
    RECEIVED(2,"已收货"),
    CANCEL(3,"已取消"),
    REFUND(4,"已退款"),
    INVALID(5,"已失效");

    private Integer code;
    private String value;
}
