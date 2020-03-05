package com.gtools.sc.example.ribbon.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 14:05
 */
@RestController
@RequestMapping("/")
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/say")
    public String say() {
        // 不好模拟，不同端口IP的服务，如何调用有，没有域名
        return restTemplate.getForObject("http://localhost:8081/hello/say", String.class);
    }

    @RequestMapping("/logUserInstance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("example-eureka-client");
        // 打印当前选择的是哪个节点
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
                serviceInstance.getPort());
    }

}
