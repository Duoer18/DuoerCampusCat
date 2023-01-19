package com.duoer.campus.service.impl;

import com.duoer.campus.dao.UserMapper;
import com.duoer.campus.entity.User;
import com.duoer.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int loginCheck(User u) {
        User userSelected = userMapper.checkUser(u);
        if (userSelected == null) { // 账号或密码错误
            return -1;
        } else { // 用户状态正常
            return userSelected.getStatus();
        }
    }

    @Override
    public int registerCheck(User u) {
        User userSelected = userMapper.selectUserByUsername(u);
        if (userSelected != null) { // 用户已存在
            return 0;
        } else { // 注册已成功
            userMapper.insertUser(u);
            return 1;
        }
    }

    @Override
    public int existCheck(User u) {
        User user = userMapper.selectUserByUsername(u);
        if (user != null) { // 用户已存在
            return 0;
        } else {
            return 1;
        }
    }
}
