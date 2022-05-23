package com.example.order;

import lombok.extern.slf4j.Slf4j;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/4/21 18:35
 */
@Slf4j
public abstract class AbstractOrderStatusChangeHandler {

    // 将修改为什么状态
    public abstract OrderStatus to();

    public Order handler(Order order,Object data){
        log.info("订单状态由【{}】修改为【{}】,请求参数：{}",order.getOrderStatus(),to(),data);
        change(order,data);
        log.info("订单状态已修改为【{}】",order.getOrderStatus());
        return order;
    }

    // 订单状态实际修改
    public abstract Order change(Order order,Object data);
}
