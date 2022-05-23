package com.example.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/5/23 11:51
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderStatusChangeService {

    private List<AbstractOrderStatusChangeHandler> orderStatusChangeHandlers;

    private List<AbstractOrderStatusChangeListener> changeListeners;


    public void change(Order order,OrderStatus to,Object data){
        OrderStatus from = order.getOrderStatus();
        List<AbstractOrderStatusChangeHandler> handlers = orderStatusChangeHandlers.stream()
                .filter(opera -> opera.to().equals(to))
                .collect(Collectors.toList());
        List<AbstractOrderStatusChangeListener> matchListeners = changeListeners.stream()
                .filter(listen -> listen.match(from, to))
                .collect(Collectors.toList());
        // 操作类只有一个，监听类有多个。
        // 根据to，获取订单状态修改操作类，当有多个时，报错
        if(handlers.size() > 1){
            throw new RuntimeException("存在多个实现类");
        }
        matchListeners.stream().forEach(listen -> listen.beforeChange(order,from,to,data));
        handlers.stream().forEach(opera->opera.change(order,data));
        // 执行对应修改类
        matchListeners.stream().forEach(listen -> listen.afterChange(order,from,to,data));
    }

}
