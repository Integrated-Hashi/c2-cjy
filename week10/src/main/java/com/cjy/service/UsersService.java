package com.cjy.service;

import com.cjy.domain.Users;

import java.util.List;

public interface UsersService {
    public List<Users> findUsers();
    public void insertUsers(Users users);
    public boolean login(Users users);
}
