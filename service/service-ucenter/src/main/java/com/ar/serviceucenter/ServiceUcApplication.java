package com.ar.serviceucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author JerryIcon
 * @create 2022-01-04 17:38
 */
@ComponentScan({"com.ar"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("com.ar.serviceucenter.mapper")
public class ServiceUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUcApplication.class, args);
    }
}