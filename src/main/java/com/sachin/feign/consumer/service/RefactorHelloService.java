package com.sachin.feign.consumer.service;

import com.sachin.springcloud.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author Sachin
 * @Date 2020/10/13
 **/
@FeignClient(value = "Hello-Service")
public interface RefactorHelloService extends HelloService {
}
