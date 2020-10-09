package com.sachin.feign.consumer.controller;

import com.sachin.entity.User;
import com.sachin.entity.service.HelloService;
import org.springframework.stereotype.Controller;

@Controller
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello+" + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "hello:" + user.getName() + ":age:" + user.getAge();
    }
}
