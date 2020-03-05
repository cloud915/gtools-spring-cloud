package com.gtools.sample.feign.client.service;

import com.gtools.sample.feign.client.config.HelloFeignServiceConfig;
import com.gtools.sample.feign.client.service.hystrix.HelloSelfFeginServiceFallback;
import com.gtools.sample.feign.client.service.hystrix.HelloSelfFeginServiceFallbackFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/10 18:21
 */
// 采用fallbackFactory方式，可以捕获异常信息
@FeignClient(name = "github-client", url = "http://localhost:8081", configuration = HelloFeignServiceConfig.class,
        //fallback = HelloSelfFeginServiceFallback.class,
        fallbackFactory = HelloSelfFeginServiceFallbackFactory.class)
public interface HelloSelfFeginService {
    @RequestMapping(value = "/hello/say", method = RequestMethod.GET)
//    @LoadBalanced // 实现负载均衡
    String say();
}
