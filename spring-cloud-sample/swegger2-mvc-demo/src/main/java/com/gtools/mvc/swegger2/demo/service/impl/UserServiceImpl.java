package com.gtools.mvc.swegger2.demo.service.impl;

import com.gtools.mvc.swegger2.demo.model.User;
import com.gtools.mvc.swegger2.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/11 16:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static List<User> list = new LinkedList<>();

    @Override
    public List<User> page(int page, int size) {
        int from = page <= 0 ? 0 : ((page - 1) * size);
        return list.stream().skip(from).limit(size).collect(Collectors.toList());
    }

    @Override
    public void insert(User user) {
        User local = list.stream().filter(c -> c.getId().equals(user.getId())).findAny().orElse(null);
        if (local == null) {
            list.add(user);
        }
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        list.stream().filter(c -> c.getId().equals(id)).findAny().ifPresent(local -> list.remove(local));
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return list.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
    }
}
