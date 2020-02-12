package com.gtools.sample.feign.client.service.hystrix;

import com.gtools.sample.feign.client.service.HelloSelfFeginService;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 11:01
 */
@Component
public class HelloSelfFeginServiceFallback implements HelloSelfFeginService {
    @Override
    public String say() {
        return "say error";
    }
}
