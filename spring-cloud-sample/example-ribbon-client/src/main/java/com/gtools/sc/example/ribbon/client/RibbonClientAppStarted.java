package com.gtools.sc.example.ribbon.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 14:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonClientAppStarted {
    public static void main(String[] args) {
        SpringApplication.run(RibbonClientAppStarted.class, args);
    }

    @Bean
    @LoadBalanced  // 实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
