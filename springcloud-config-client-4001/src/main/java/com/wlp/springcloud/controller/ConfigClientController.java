package com.wlp.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    //这里的配置就是git中对应的config-client.yml 配置文件中的配置项

    @Value("${spring.application.name}")
    private String applicationName ;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer ;

    @Value("${server.port}")
    private String port ;

    @RequestMapping("/config")
    public String gerConfig(){
        return "applicationName:"+applicationName+",eurekaServer:"+eurekaServer+",port:"+port;
    }
}
