package com.gtools.sc.example.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 9:54
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
public class HystrixClientAppStarted {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClientAppStarted.class,args);
    }
}
