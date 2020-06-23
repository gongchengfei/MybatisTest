package com.gcf.controller;

import com.gcf.entity.User;
import com.gcf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/all")
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

//    @RequestMapping("/one/{pid}")
//    public User getUserById(@PathVariable String pid){
//        System.out.println(pid);
//        return userMapper.getUserById(pid);
//    }

    @RequestMapping("/one")
    public User getUserById(@RequestParam(name = "ppid") String pid){
        System.out.println(pid);
        return userMapper.getUserById(pid);
    }
}
