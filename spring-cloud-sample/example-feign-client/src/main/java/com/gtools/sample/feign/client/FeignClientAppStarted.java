package com.gtools.sample.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/10 15:49
 */
@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
public class FeignClientAppStarted {
    // 独立的，只是springboot的项目，目的是service中以feign形式引用远端暴露的api
    public static void main(String[] args) {
        SpringApplication.run(FeignClientAppStarted.class, args);
    }
}
