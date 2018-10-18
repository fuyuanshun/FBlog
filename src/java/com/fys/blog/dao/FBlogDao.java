package com.fys.blog.dao;

import com.fys.blog.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fBlogDao")
public interface FBlogDao {
    List<User> selectUser();
}
