package com.example.servicezuul;

import com.example.servicezuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 添加注解声明是注册中心客户端
@EnableEurekaClient
// 开启网管
@EnableZuulProxy
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    // 实例化tokenfilter,否则网管不生效
    @Bean
    TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
