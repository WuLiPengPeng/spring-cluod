package com.wlp.springcloud.service;

import com.wlp.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//服务降级
//需要配置到@FeignClient的FallbackFactory中
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                Dept dept = new Dept().setDeptno(id)
                        .setDname("客户端提供服务降级，服务已暂停使用")
                        .setDb_source("no database");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                List<Dept> list = new ArrayList<>();
                Dept dept = new Dept().setDeptno(-1L)
                        .setDname("客户端提供服务降级，服务已暂停使用")
                        .setDb_source("no database");
                list.add(dept);
                return list;
            }
        };
    }
}
