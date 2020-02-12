package com.gtools.sample.feign.client.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description 自定义，禁用Hystrix功能
 * @Author ghy
 * @Date 2020/2/12 11:27
 */
@Configuration
public class FeignDisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    //在想要禁用Hystrix的@FeignClient引用该配置类即可
    // @FeignClient(name = "microservice-provider-user", configuration = FeignDisableHystrixConfiguration.class)
    // com/gtools/sample/feign/client/service/HelloFeignService.java:18
}
