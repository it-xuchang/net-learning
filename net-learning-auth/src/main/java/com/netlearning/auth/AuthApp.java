package com.netlearning.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:11
 */
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan("com.netlearning.framework.domain.ucenter")//扫描实体类
@ComponentScan(basePackages={"com.netlearning.api"})//扫描接口
@ComponentScan(basePackages={"com.netlearning.framework"})//扫描common下的所有类
@SpringBootApplication
public class AuthApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
