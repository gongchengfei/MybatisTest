package com.gcf;

import com.gcf.entity.User;
import com.gcf.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisTest.class)
public class MybatisTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getAllUser(){
        List<User> users = userMapper.getAllUser();
        System.out.println(users.toString());
    }
}
