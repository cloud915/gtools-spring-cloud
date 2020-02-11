package com.gtools.mvc.swegger2.demo.controller;

import com.gtools.mvc.swegger2.demo.model.User;
import com.gtools.mvc.swegger2.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/11 16:22
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几条记录", required = true),
            @ApiImplicitParam(name = "size", value = "每页容量", required = true)
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<User> page(Integer page, Integer size) {
        return userService.page(page, size);
    }

    @ApiOperation(value = "添加用户", notes = "根据用户名、年龄创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true)
    })
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(String name, Integer age) {
        User user = new User(System.currentTimeMillis() / 1000, name, age);
        userService.insert(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据主键删除用户")
    @ApiImplicitParam(name = "id", value = "主键", required = true)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(Long id) {
        userService.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "查询用户", notes = "根据主键查询用户")
    @ApiImplicitParam(name = "id", value = "主键", required = true)
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public User selectByPrimaryKey(Long id) {
        return userService.selectByPrimaryKey(id);
    }
}
