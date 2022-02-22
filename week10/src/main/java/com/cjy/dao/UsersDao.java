package com.cjy.dao;

import com.cjy.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao {
    @Select("select * from users")
    public List<Users> findUsers();

    @Insert("INSERT INTO USERS (username,password,age,mobile) VALUES(#{username},#{password},#{age},#{mobile})")
    public void insertUsers(Users users);

    @Select("select * from users where username=#{username} and password=#{password}")
    public Users login(Users users);
}
