package com.fys.blog.service.impl;

import com.fys.blog.dao.FBlogDao;
import com.fys.blog.pojo.User;
import com.fys.blog.service.FBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fBlogService")
public class FBlogServiceImpl implements FBlogService {
    @Autowired()
    private FBlogDao fBlogDao;

    @Override
    public List<User> selectUser() {
        return fBlogDao.selectUser();
    }
}