package com.gtools.sc.example.hystrix.client.controller;

import com.gtools.sc.example.hystrix.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 10:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    // http://localhost:8082/user/getUser?name=spring
    // http://localhost:8082/user/getUser?name=aaa
    @GetMapping(value = "/getUser")
    public String getUser(String name) throws Exception {
        return userService.getUser(name);
    }

}
