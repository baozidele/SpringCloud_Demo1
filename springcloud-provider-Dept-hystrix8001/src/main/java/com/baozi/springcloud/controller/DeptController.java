package com.baozi.springcloud.controller;

import com.baozi.springcloud.pojo.Dept;
import com.baozi.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping("/dept/add")

    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixget")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept==null)
            throw new RuntimeException("没有该记录");
        return dept;
    }


    public Dept hystrixget(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("不存在id为： "+id+" 的记录");
    }
    @RequestMapping("dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/instance")
    public Object discover(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances){
            System.out.println(instance.getHost() + "\t" + // 主机名称
                    instance.getPort() + "\t" + // 端口号
                    instance.getUri() + "\t" + // uri
                    instance.getServiceId() // 服务id
            );
        }
        return this.discoveryClient;
    }
}
