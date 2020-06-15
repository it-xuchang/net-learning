package com.netlearning.user.service.impl;

import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.pojo.Order;
import com.netlearning.user.service.OrderService;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/13 22:19
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String handle(Order order) {
        if (StringUtils.equals("1",order.getType())){
            return "1";
        }else if (StringUtils.equals("2",order.getType())){
            return "2";
        }else if (StringUtils.equals("3",order.getType())){
            return "3";
        }
        return null;
    }
}
