package com.sachin.feign.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Sachin
 * @Date 2020/10/11
 **/
@RestController //标注 对所有的/error 请求 使用application/json
@RequestMapping("/error")
public class FinalExceptinoController extends AbstractErrorController {

    public FinalExceptinoController(ErrorAttributes errorAttributes, ServerProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);

    }
    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, true);
        HttpStatus status=getStatus(request);
        return new ResponseEntity(body, status);
    }


    /**
     * 为什么会有getErrorPath呢？ 原因是AbstractErrorController在设计时会考虑根据不同的错误状态码4xx 5xx到不同的路径下找不同的文件
     * 在我们的需求中 要求 返回json，因此这个方法可以不实现
     * @return
     */
    @Override
    public String getErrorPath() {
        return null;
    }
}
