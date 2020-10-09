package com.sachin.feign.consumer.service;

import com.sachin.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("Hello-Service")//注意这里的服务名不区分大小写，hello-service和HELLO-SERViCE都可以
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/helllo2",method = RequestMethod.GET)
    User hello(@RequestHeader(name = "name") String name,@RequestHeader(name = "age")Integer age);


    @RequestMapping(value = "/hello3",method=RequestMethod.POST)
    String hello(@RequestBody User user);

}
