package com.netlearning.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 14:17
 */
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.netlearning.user.mapper")
@EntityScan("com.netlearning.framework.domain.userAuth")
@ComponentScan(basePackages={"com.netlearning.api"})//扫描api接口
@ComponentScan(basePackages={"com.netlearning.user"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.netlearning.framework"})
@SpringBootApplication
public class UserAuthApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserAuthApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
