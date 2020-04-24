package com.wlp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wlp.springcloud.pojo.Dept;
import com.wlp.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供REST full 服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService ;

    /*
           服务熔断 和 服务降级 容易混淆的点
           服务熔断：是当请求的服务不可用（网络或其他原因）时，使用备选方案给客户端一个简单的返回

           服务降级：是当某个服务的负载 或 预期负载会超标时，通过将其他闲置服务，或当时不重要的服务延迟使用或暂停使用
                    以保证有足够的资源给当前的主要负载服务使用
     */

    @HystrixCommand(fallbackMethod = "hystrixGet")//当下面方法执行错误后，调用备选方案,此注解需要先开启熔断支持:@EnableCircuitBreaker
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept ==null){
            throw new RuntimeException("id:["+id+"]没有查询到该用户信息");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id")Long id){

        //要导入lombok 依赖，以及IDEA安装lombok插件，方可使用，不然会报红
        Dept dept = new Dept()
                .setDeptno(id)
                .setDname("id=>" + id + "没有对应的信息 --null@Hystrix")
                .setDb_source("no this database in MySql");
        return dept ;
    }


}
