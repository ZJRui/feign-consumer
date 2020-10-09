package com.sachin.feign.consumer.service;

import com.sachin.entity.User;
import com.sachin.entity.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {


}
