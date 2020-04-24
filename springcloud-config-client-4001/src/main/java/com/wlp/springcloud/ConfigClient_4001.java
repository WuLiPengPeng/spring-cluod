package com.wlp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *此模块启动端口是根据config-client.yml的配置的激活环境所选端口
 */

@SpringBootApplication
public class ConfigClient_4001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_4001.class,args);
    }
}
