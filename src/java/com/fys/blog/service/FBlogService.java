package com.fys.blog.service;

import com.fys.blog.pojo.User;

import java.util.List;

public interface FBlogService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectUser();

    /**
     * 用户注册
     */
    void register(User user);

    /**
     * 通过用户名查询用户是否已经存在
     */
    String userIsExist(String username);

    /**
     * 通过用户名查询用户是否存在于数据库中
     * @param username
     * @return
     */
    String checkUserIsExist(String username);
}
