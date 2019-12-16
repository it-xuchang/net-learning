package com.netlearning.fss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 10:51
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.netlearning.fss.mapper")
@EntityScan("com.netlearning.framework.domain.fss")//model
@ComponentScan(basePackages={"com.netlearning.api"})//api
@ComponentScan(basePackages={"com.netlearning.fss"})//扫描本项目
@ComponentScan(basePackages={"com.netlearning.framework"})//common
@Configuration
public class FssApp {

	public static void main(String[] args) {
		SpringApplication.run(FssApp.class, args);
	}

}
