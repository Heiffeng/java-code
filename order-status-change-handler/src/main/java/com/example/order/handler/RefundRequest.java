package com.example.order.handler;

import lombok.Data;

import java.io.Serializable;

/**
 * Description
 *
 * @Author: SunAo
 * @Date: 2022/4/21 18:51
 */
@Data
public class RefundRequest implements Serializable {

    private String refundReason;
}
