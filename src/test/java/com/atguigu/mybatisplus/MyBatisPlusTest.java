package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-05-11-[下午 3:28]-周四
 */
@SpringBootTest
public class MyBatisPlusTest {

    //对IOC容器所管理的组件进行自动装配
    //在测试类中自动装配UserMapper接口对象

    @Autowired
    private UserMapper userMapper;  //在IOC容器中只能存在类所对应的Bean不能存在接口所对应的Bean

    /**
     * 通过条件构造器查询一个List集合，若没有条件，则可以设置null为参数
     */
    @Test
    public void testSelectList() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    /**
     * 实现新增用户信息
     * INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atguigu.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
    }

    /**
     * 通过id删除用户信息
     * DELETE FROM user WHERE id=?
     */
    @Test
    public void testDelete1() {
        int result = userMapper.deleteById(1656643975907680257L);
        System.out.println("result:" + result);
    }

    /**
     * 根据Map集合中所设置的条件删除用户信息
     * DELETE FROM user WHERE name = ? AND age = ?
     */
    @Test
    public void testDelete2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /**
     * 实现多个id实现批量删除
     * DELETE FROM user WHERE id IN ( ? , ? , ? )
     */
    @Test
    public void testDelete3() {
        List<Long> list = Arrays.asList(6L, 7L, 8L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }

    /**
     * 修改用户信息
     * UPDATE user SET name=?, email=? WHERE id=?
     */
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);
        System.out.println("result:" + result);
    }

    /**
     * 通过id查询用户信息
     */
    @Test
    public void testSelect() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 根据多个id查询多个用户信息
     * SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? , ? )
     */
    @Test
    public void testSelect2() {
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    /**
     * 根据map集合中的条件查询用户信息
     * SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
     */
    @Test
    public void testSelect3() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 查询所有数据
     * SELECT id,name,age,email FROM user
     */
    @Test
    public void testSelect4() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 自定义查询
     * select id, name, age, email from user where id = ?
     * {name=Jone, id=1, age=18, email=test1@baomidou.com}
     */
    @Test
    public void testSelect5() {
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

}

