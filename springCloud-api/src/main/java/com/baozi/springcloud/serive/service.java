package com.baozi.springcloud.serive;

import com.baozi.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface service {

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept);

    @RequestMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @RequestMapping("dept/list")
    public List<Dept> queryAll();
}
