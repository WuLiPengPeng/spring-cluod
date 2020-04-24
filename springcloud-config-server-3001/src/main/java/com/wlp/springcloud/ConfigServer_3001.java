package com.wlp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//启用配置服务
public class ConfigServer_3001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3001.class,args);
    }
}
