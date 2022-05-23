package com.example.order;

import java.util.Arrays;
import java.util.Collection;

/**
 * Description
 * TODO 添加监听类排序
 * @Author: SunAo
 * @Date: 2022/5/23 11:53
 */
public abstract class AbstractOrderStatusChangeListener {

    /**
     * 当状态被修改时
     * @param order 修改后的order
     * @param from 修改前的order状态
     */
    public abstract void afterChange(Order order, OrderStatus from,OrderStatus to,Object data);

    public abstract void beforeChange(Order order, OrderStatus from,OrderStatus to,Object data);

    public abstract Collection<OrderStatus> from();

    public abstract Collection<OrderStatus> to();

    public boolean match(OrderStatus from,OrderStatus to){
        return from().contains(from) && to().contains(to);
    }
}
