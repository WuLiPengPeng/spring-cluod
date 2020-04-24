package com.wlp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@Configuration 相当于Spring中的application.xml配置文件
public class ConfigBean {


    //配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced//Ribbon 负载均衡注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /*@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }*/
}
