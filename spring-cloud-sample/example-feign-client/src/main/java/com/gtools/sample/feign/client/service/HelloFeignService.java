package com.gtools.sample.feign.client.service;

import com.gtools.sample.feign.client.config.FeignDisableHystrixConfiguration;
import com.gtools.sample.feign.client.config.HelloFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/10 15:50
 */
@FeignClient(name = "github-client", url = "https://api.github.com",
        configuration = {HelloFeignServiceConfig.class,
                // 禁用熔断
                FeignDisableHystrixConfiguration.class})
public interface HelloFeignService {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);

}
