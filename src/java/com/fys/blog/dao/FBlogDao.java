package com.fys.blog.dao;

import com.fys.blog.pojo.User;
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
}
