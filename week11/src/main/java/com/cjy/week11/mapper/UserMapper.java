package com.cjy.week11.mapper;

import com.cjy.week11.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchRemoveUser(List<Integer> ids);

    /**
     * 获取用户数量
     * @return
     */
    int getUserNum();

    /**
     * 获取男性用户数量
     * @return
     */
    int getManNum();

    /**
     * 用户名是否存在
     * @return
     */
    int isExists(String username);

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
