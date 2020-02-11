package com.gtools.sample.feign.client.service;

import com.gtools.sample.feign.client.config.HelloFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/10 18:21
 */
@FeignClient(name = "github-client", url = "http://localhost:8081", configuration = HelloFeignServiceConfig.class)
public interface HelloSelfFeginService {
    @RequestMapping(value = "/hello/say", method = RequestMethod.GET)
    String say();
}
