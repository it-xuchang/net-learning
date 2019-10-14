package com.netlearning.manage.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EntityScan("com.netlearning.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.netlearning.api"})//扫描api接口
@ComponentScan(basePackages={"com.netlearning.manage.cms"})//扫描本项目下的所有类
@ComponentScan(basePackages={"com.netlearning.framework"})
@EnableEurekaClient
public class ManageCmsApp {

	public static void main(String[] args) {
		SpringApplication.run(ManageCmsApp.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}

