package com.netlearning.file;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.netlearning.framework.domain.filesystem")//实体类
@ComponentScan(basePackages={"com.netlearning.api"})//api
@ComponentScan(basePackages={"com.netlearning.framework"})//common
@ComponentScan(basePackages={"com.netlearning.file.dao"})//本项目
public class FileApp {
    public static void main(String[] args) {
        SpringApplication.run(FileApp.class,args);
    }


}
