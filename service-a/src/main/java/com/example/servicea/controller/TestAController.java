package com.example.servicea.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 刷新配置
@RefreshScope
public class TestAController {

    // 获取配置文件中的端口号
    @Value("${server.port}")
    private String port;
    @Value("${name}")
    private String name;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("testA")
    public String TestAController(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello,SpringCloud for TestA 端口 " + port;
    }

    @RequestMapping("/hello")
    public String hello() {
        return name;
    }

    @RequestMapping("/otherService")
    public String otherService() {
        return "我是其他服务";
    }

    String fallback(){
        return "服务器繁忙";
    }

}