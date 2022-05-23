package com.example.order;

import lombok.Data;

import java.io.Serializable;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/4/21 18:25
 */
@Data
public class Order implements Serializable {

    private String orderCode;

    private OrderStatus orderStatus;

}
