package com.example.order.handler;

import com.example.order.AbstractOrderStatusChangeHandler;
import com.example.order.Order;
import com.example.order.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/4/21 18:51
 */
@Slf4j
@Component
public class ToRefundHandler extends AbstractOrderStatusChangeHandler {

    @Override
    public OrderStatus to() {
        return OrderStatus.REFUND;
    }

    @Override
    public Order change(Order order,Object data) {
        RefundRequest request = (RefundRequest) data;
        log.info("退款原因:{}",request.getRefundReason());
        return order;
    }

}
