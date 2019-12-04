package com.netlearning.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;




@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.netlearning.framework.domain.course")//model
@ComponentScan(basePackages={"com.netlearning.api"})//api
@ComponentScan(basePackages={"com.netlearning.course"})//扫描本项目
@ComponentScan(basePackages={"com.netlearning.framework"})//common
public class CourseApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApp.class, args);
	}

}
