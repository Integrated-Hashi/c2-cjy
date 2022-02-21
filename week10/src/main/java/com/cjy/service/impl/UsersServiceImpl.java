package com.cjy.service.impl;

import com.cjy.domain.Users;
import com.cjy.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Override
    public List<Users> findUsers() {
        System.out.println("业务层：查询用户");
        return null;
    }

    @Override
    public void insertUsers(Users users) {
        System.out.println("业务层：用户注册");
    }

    @Override
    public boolean login(Users users) {
        System.out.println("业务层：用户登录");
        return false;
    }
}
