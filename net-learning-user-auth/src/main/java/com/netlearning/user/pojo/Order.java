package com.netlearning.user.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/13 22:21
 */
@Data
public class Order {
    private String type;
    private BigDecimal price;
    private String code;
}
