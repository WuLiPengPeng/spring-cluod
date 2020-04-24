package com.wlp.springcloud.controller;

import com.wlp.springcloud.pojo.Dept;
import com.wlp.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    /*
        使用【微服务名字】调用服务时。使用Ribbon
        使用【接口和注解】调用服务时。使用Feign

        Feign是以面向接口编程做设计的，其实内部还是使用的Ribbon做负载均衡
        只是外边包了一层，增加了可读性，但是性能会比RestTemplate+Ribbon的性能差
     */

    //这里使用了Feign

    @Autowired
    private DeptClientService deptClientService ;

    //方法名和请求路径中的名称不同，也可被调用，不要混淆，书写规范而已
    //可见springcloud-consumer-dept-80模块中的使用，那个模块使用的是Ribbon

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.queryById(id);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
    }
}