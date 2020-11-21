package com.baozi.springcloud.consumer;

import com.baozi.springcloud.pojo.Dept;
import com.baozi.springcloud.serive.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class consumerController {

    @Autowired
    private service service;

    //使用负载均衡时，这里要设置为服务名
//    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/add")
    public boolean add(Dept dept) {
        return service.addDept(dept);
    }

    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @RequestMapping("/list")
    public List<Dept> getAll(){
        return service.queryAll();
    }


}
