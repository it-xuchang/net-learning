package com.netlearning.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 14:17
 */
@EnableHystrix
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.netlearning.shiro.mapper")
@EntityScan("com.netlearning.framework.domain.userAuth")
@ComponentScan(basePackages={"com.netlearning.api"})//扫描api接口
@ComponentScan(basePackages={"com.netlearning.shiro"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.netlearning.framework"})
@SpringBootApplication
@EnableTransactionManagement
public class ShiroApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShiroApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
