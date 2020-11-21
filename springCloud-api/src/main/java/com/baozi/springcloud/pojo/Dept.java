package com.baozi.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept {

    private long deptno;//主键
    private String dname;//部门名称
    private String db_source;//数据库来源

    public Dept(String dname) {
        this.dname = dname;
    }
}
