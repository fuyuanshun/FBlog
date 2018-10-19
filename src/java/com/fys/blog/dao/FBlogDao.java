package com.fys.blog.dao;

import com.fys.blog.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fBlogDao")
public interface FBlogDao {
    /**
     * 查询所有的用户
     * @return
     */
    List<User> selectUser();

    /**
     * 用户注册
     */
    void register(User user);

    /**
     * 查询用户名是否已经存在
     */
    String userIsExist(String username);

    /**
     * 用户登陆，查询用户名和密码是否存在
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(@Param("username")String username, @Param("password")String password);
}
