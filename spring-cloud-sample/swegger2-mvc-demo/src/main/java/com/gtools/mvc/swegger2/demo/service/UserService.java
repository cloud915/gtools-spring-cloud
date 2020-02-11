package com.gtools.mvc.swegger2.demo.service;

import com.gtools.mvc.swegger2.demo.model.User;

import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/11 16:13
 */
public interface UserService {
    List<User> page(int page, int size);

    void insert(User user);

    void deleteByPrimaryKey(Long id);

    User selectByPrimaryKey(Long id);
}
