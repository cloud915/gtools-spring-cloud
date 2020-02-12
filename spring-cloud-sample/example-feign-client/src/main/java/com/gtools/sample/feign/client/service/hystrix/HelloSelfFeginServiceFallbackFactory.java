package com.gtools.sample.feign.client.service.hystrix;

import com.gtools.sample.feign.client.service.HelloSelfFeginService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 11:14
 */
@Component
public class HelloSelfFeginServiceFallbackFactory implements FallbackFactory<HelloSelfFeginService> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloSelfFeginServiceFallbackFactory.class);

    @Override
    public HelloSelfFeginService create(Throwable throwable) {
        return () -> {
            HelloSelfFeginServiceFallbackFactory.LOGGER.info("fallback; reason was: ", throwable);
            return "feign fallback factory";
        };
        // 等价于
        /*return new HelloSelfFeginService() {
            @Override
            public String say() {
                return "feign fallback factory";
            }
        };*/
    }
}
