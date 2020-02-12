package com.gtools.sample.feign.client.controller;

import com.gtools.sample.feign.client.service.HelloFeignService;
import com.gtools.sample.feign.client.service.HelloSelfFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/10 15:53
 */
@RestController
@RequestMapping("/")
public class HelloFeignController {
    @Autowired
    private HelloFeignService helloFeignService;
    @Autowired
    private HelloSelfFeginService helloSelfFeginService;

    //http://localhost:8083/search/github?str=spring-cloud-dubbo
    @GetMapping(value = "search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return helloFeignService.searchRepo(queryStr);
    }
    // http://localhost:8083/self/say
    @GetMapping(value = "self/say")
    public String selfSay() {
        return helloSelfFeginService.say();
    }


}
