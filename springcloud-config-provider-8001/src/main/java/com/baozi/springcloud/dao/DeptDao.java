package com.baozi.springcloud.dao;

import com.baozi.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sun.plugin.PluginURLJarFileCallBack;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
