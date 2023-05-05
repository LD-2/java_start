package com.mirror.service.impl;

import com.mirror.mapper.UserMapper;
import com.mirror.pojo.User;
import com.mirror.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

//    @Autowired
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectUserPage(String userName, String userSex, int startIndex) {
        return userMapper.selectUserPage(userName,userSex,startIndex);
    }

    @Override
    public int getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName,userSex);
    }

    @Override
    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

}
