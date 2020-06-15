package com.netlearning.user.service.impl;

import com.netlearning.user.pojo.Order;
import com.netlearning.user.service.OrderService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/16 14:52
 */
public class OrderServiceV3Impl implements OrderService {
    private String calcOrdinary(Order order) {
        System.out.println("处理普通用户的账单计费:" + order.getCode());
        return "处理普通用户的账单计费:" + order.getCode();
    }

    private String calcVip1(Order order) {
        System.out.println("处理vip1级用户的账单计费:" + order.getCode());
        return "处理vip1级用户的账单计费:" + order.getCode();
    }

    private String calcVip2(Order order) {
        System.out.println("处理vip2级用户的账单计费" + order.getCode());
        return "处理vip2级用户的账单计费:" + order.getCode();
    }
    public Function<Order, String> getFunction(Order order) {
        //入参--返回
        Function<Order,String> ordinary = order1 -> calcOrdinary(order);
        Function<Order,String> vip1 = order1 -> calcVip1(order);
        Function<Order,String> vip2 = order1 -> calcVip2(order);
        Supplier<Map<String,Function<Order,String>>> supplier = () ->{
            Map<String,Function<Order,String>> map = new HashMap<>();
            map.put("ordinary",ordinary);
            map.put("vip1",vip1);
            map.put("vip2",vip2);
            return map;
        };
        return supplier.get().get(order.getType());
    }

    @Override
    public String handle(Order order) {

        this.getFunction(order).apply(order);
        return order.getType();
    }
    public String test(Order order) {

        String result = this.getFunction(order).apply(order);
        return order.getType();
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setType("vip1");
        order.setCode("vip1");
        order.setPrice(new BigDecimal(500.22));
        OrderServiceV3Impl v = new OrderServiceV3Impl();
        v.test(order);
    }
}
