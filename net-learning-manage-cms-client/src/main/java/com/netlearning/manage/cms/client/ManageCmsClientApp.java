package com.netlearning.manage.cms.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.netlearning.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.netlearning.api"})//扫描api接口
@ComponentScan(basePackages={"com.netlearning.manage.cms.client"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.netlearning.framework"})
@EnableEurekaClient
public class ManageCmsClientApp {

	public static void main(String[] args) {
		SpringApplication.run(ManageCmsClientApp.class, args);
	}


}

