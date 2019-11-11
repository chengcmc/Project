package com.project.manager.Service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.project.domain.User;
import com.project.manager.mapper.UserMapper;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }
}
