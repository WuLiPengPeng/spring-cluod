package com.wlp.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门实体类
 *
 * orm 类表关系映射
 */

@Data//get set toString
@NoArgsConstructor//自动生成无参构造
@Accessors(chain = true)//链式写法

public class Dept implements Serializable {

    //部门ID
    private Long deptno ;

    //部门名称
    private String dname;

    //代表数据存在哪个数据库（微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库）
    private String db_source ;

    public Dept(String dname) {
        this.dname = dname;
    }
}
