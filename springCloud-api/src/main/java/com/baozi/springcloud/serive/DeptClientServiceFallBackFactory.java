package com.baozi.springcloud.serive;

import com.baozi.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new service() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDname("服务暂时休息").setDeptno(id);
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
