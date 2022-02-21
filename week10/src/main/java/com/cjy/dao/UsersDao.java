package com.cjy.dao;

import com.cjy.domain.Users;

import java.util.List;

public interface UsersDao {
    public List<Users> findUsers();
    public void insertUsers(Users users);
    public Users login(Users users);
}
