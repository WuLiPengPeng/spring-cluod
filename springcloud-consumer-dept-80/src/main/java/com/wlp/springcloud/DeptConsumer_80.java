package com.wlp.springcloud;

import com.wlp.myrule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// Ribbon 和Eureka整合后，客户端可以直接调用，而不用关心IP和端口号
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义的Rule类（自定义负载均衡算法）
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = CustomRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
