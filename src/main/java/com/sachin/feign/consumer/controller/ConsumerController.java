package com.sachin.feign.consumer.controller;

import com.sachin.entity.User;
import com.sachin.feign.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsumerController {


    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String hello() {
        return helloService.hello();
    }


    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String hello2() {
        StringBuilder builder = new StringBuilder();
        builder.append(helloService.hello() + "\n");
        builder.append(helloService.hello("DDI"));
        builder.append(helloService.hello("zhangsan", 20));
        builder.append(helloService.hello(new User("lisi", 29)));

        return builder.toString();

    }


}
