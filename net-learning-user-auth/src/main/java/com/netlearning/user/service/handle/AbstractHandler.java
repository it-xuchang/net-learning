package com.netlearning.user.service.handle;

import com.netlearning.user.pojo.Order;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/13 22:27
 */
public abstract class AbstractHandler {

    abstract public String handle(Order dto);

}
