package com.netlearning.user.service.handle.biz;

import com.netlearning.user.pojo.Order;
import com.netlearning.user.service.handle.AbstractHandler;
import com.netlearning.user.service.handle.HandlerType;
import org.springframework.stereotype.Component;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/13 22:38
 */
@Component
@HandlerType("2")
public class GroupHandler extends AbstractHandler {

    @Override
    public String handle(Order dto) {
        return "处理团购订单";
    }

}
