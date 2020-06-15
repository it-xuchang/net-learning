package com.netlearning.user.service.impl;

import com.netlearning.user.pojo.Order;
import com.netlearning.user.service.OrderService;
import com.netlearning.user.service.handle.AbstractHandler;
import com.netlearning.user.service.handle.HandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/13 22:33
 */
@Service
public class OrderServiceV2Impl implements OrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(Order dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
    }

}
