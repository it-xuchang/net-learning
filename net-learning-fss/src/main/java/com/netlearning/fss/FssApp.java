package com.netlearning.fss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 10:51
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.netlearning.framework.domain.fss")//model
@ComponentScan(basePackages={"com.netlearning.api"})//api
@ComponentScan(basePackages={"com.netlearning.fss"})//扫描本项目
@ComponentScan(basePackages={"com.netlearning.framework"})//common
@Configuration
public class FssApp {

	public static void main(String[] args) {
		SpringApplication.run(FssApp.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("10MB");
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("100MB");
		return factory.createMultipartConfig();
	}
}
