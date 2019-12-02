package com.example.serviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 开启注册中心客户端
@EnableEurekaClient
// 开启配置中心服务器
@EnableConfigServer
public class ServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigApplication.class, args);
    }

}
