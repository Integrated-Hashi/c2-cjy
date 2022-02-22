package com.cjy.service.impl;

import com.cjy.dao.UsersDao;
import com.cjy.domain.Users;
import com.cjy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findUsers() {
        System.out.println("业务层：查询用户");
        return usersDao.findUsers();
    }

    @Override
    public void insertUsers(Users users) {
        System.out.println("业务层：用户注册");
        usersDao.insertUsers(users);
    }

    @Override
    public boolean login(Users users) {
        System.out.println("业务层：用户登录");
        if (usersDao.login(users) == null) {
            return false;
        } else {
            return true;

        }
    }
}
