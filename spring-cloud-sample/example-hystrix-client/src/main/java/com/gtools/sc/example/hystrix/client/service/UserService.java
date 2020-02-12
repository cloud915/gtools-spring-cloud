package com.gtools.sc.example.hystrix.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/12 9:58
 */
@Service
public class UserService {

    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String name) throws Exception {
        if(name.equals("spring")){
            return "this is real user";
        }else{
            throw new Exception();
        }
    }

    /**
     * 出错，则调用该方法返回预定友好错误
     * @param name
     * @return
     */
    public String defaultUser(String name){
        return "The user does not exist in this system.";
    }
}
