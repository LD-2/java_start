package com.mirror.service.impl;

import com.mirror.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public void Hello() {
        System.out.println("此bean 对象生成了");
    }
}
