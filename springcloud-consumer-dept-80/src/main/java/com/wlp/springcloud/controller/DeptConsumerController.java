package com.wlp.springcloud.controller;

import com.wlp.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //理解：消费者不该有service层
    //RestTemplate,供我们直接调用就行了


    //这个restTemplate 是由config包下的ConfigBean配置注入的
    @Autowired
    //提供多种便捷访问远程http服务的方法，简单的RestFull模板
    private RestTemplate restTemplate ;

    //private static  final String REST_URL_PREFIX="http://localhost:8001";

    //使用了Ribbon做前端负载均衡后,我们这里应该是一个变量，而不是一个写死的值，应该通过一个服务名来访问
    private static  final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class) ;
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}


