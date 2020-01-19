package com.gtools.sc.example.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/19 17:37
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "Hello "+System.currentTimeMillis();
    }
}
