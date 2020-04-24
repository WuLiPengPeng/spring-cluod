package com.wlp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@Configuration 相当于Spring中的application.xml配置文件
public class ConfigBean {


    //IRule 负载均衡策略

    //AvailabilityFilteringRule: 会先过滤掉跳闸、访问故障的服务，剩下的服务轮训访问
    //RoundRobinRule: 轮训（默认的）
    //RandomRule: 随机
    //RetryRule: 会先按照轮训获取服务，如果获取服务失败，则会在指定时间内重试


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
