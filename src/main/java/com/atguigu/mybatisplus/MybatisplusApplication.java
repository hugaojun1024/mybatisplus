package com.atguigu.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描Mapper接口所在的包
//添加了MapperScan之后就可以将指定的包下的所有的Mapper接口所动态生成的代理类交给IOC容器管理
@MapperScan("com/atguigu/mybatisplus/mapper")
//启动类
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
