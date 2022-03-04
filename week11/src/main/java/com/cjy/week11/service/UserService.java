package com.cjy.week11.service;

import com.cjy.week11.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    boolean batchRemoveUser(List<Integer> ids);

    /**
     * 获取总的用户数
     * @return
     *
     */
    int getUserNum();

    /**
     * 获取男性用户数量
     * @return
     */
    int getUserOfMan();

    /**
     * 用户名是否存在
     * @return
     */
    boolean isExistUser(String username);

    /**
     * 根据用户名查询用户
     * @return
     */
    User getUserByName(String username);

    /**
     * 根据ids批量查询用户
     * @param ids
     * @return
     */
    List<User> getUserByIds(List<Integer> ids);
}
