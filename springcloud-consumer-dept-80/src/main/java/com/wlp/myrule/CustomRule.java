package com.wlp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡算法
 *
 * 官网原意：
 * 此类必须是@Configuration，但请注意，它不在主应用程序上下文的@ComponentScan中，
 * 否则将由所有@RibbonClients共享。如果您使用@ComponentScan（或@SpringBootApplication），
 * 则需要采取措施避免包含（例如将其放在一个单独的，不重叠的包中，或者指定要在@ComponentScan）
 *
 * 此类不能和启动类同级，否则会被所有的Ribbon客户端共享配置
 */
@Configuration
public class CustomRule{

    /*@Bean
    public IRule getRule(){
        return new CustomRandomRule();
    }*/
}
