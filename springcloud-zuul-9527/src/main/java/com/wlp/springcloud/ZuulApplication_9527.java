package com.wlp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//http://localhost:9527/springcloud-provider-dept/dept/get/10
//访问时要通过服务名（变为全小写）【springcloud-provider-dept】来访问
@SpringBootApplication
@EnableZuulProxy//开启Zuul代理
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class,args);
    }
}
