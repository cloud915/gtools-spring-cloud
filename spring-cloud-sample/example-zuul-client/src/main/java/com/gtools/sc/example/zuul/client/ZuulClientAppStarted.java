package com.gtools.sc.example.zuul.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description
 * @Author ghy
 * @Date 2020/3/5 11:06
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulClientAppStarted {
    public static void main(String[] args) {
        SpringApplication.run(ZuulClientAppStarted.class, args);
    }
}
