package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-05-11-[下午 3:13]-周四
 */
@Data
//设置实体类所对应的表名
@TableName("t_user")
public class User {

    //将属性对应的字段指定为主键
    @TableId
    //private Long uid;
    private Long id;

    private String name;

    private Integer age;

    private String email;

}
