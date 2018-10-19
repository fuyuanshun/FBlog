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

    /**
     * 查询所有的用户信息
     * @return
     */
    @Override
    public List<User> selectUser() {
        return fBlogDao.selectUser();
    }

    /**
     * 用户注册
     * @param user 用户信息
     */
    @Override
    public void register(User user) {
        fBlogDao.register(user);
    }

    /**
     *通过用户名查询用户是否已经存在
     */
    @Override
    public String userIsExist(String username) {
        return fBlogDao.userIsExist(username);
    }

    /**
     * Ajax异步查询用户名是否已经存在于数据库
     */
    public String checkUserIsExist(String username) {
        if (null != username && !"".equals(username)) {
            if (null == userIsExist(username)) {
                return "用户名可以使用";
            }
            return "用户名已经存在";
        } else {
            return "用户名已经存在";
        }
    }

    /**
     **用户登录，查询用户名和密码是否存在
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String username, String password) {
        return fBlogDao.login(username, password);
    }

    /**
     * 更新用户最后一次登陆的时间
     * @param username 需要更新的用户名
     */
    @Override
    public void updateLoginTime(String username) {
        fBlogDao.updateLoginTime(username);
    }

    /**
     * 根据用户名查询用户的社区名称
     * @param username 用户名
     * @return
     */
    @Override
    public String selectNameByUsername(String username) {
        return fBlogDao.selectNameByUsername(username);
    }

    /**
     * 查询一个社区昵称是否已经存在
     * @param nickname 社区昵称
     * @return
     */
    @Override
    public String checkNickname(String nickname) {
        return fBlogDao.checkNickname(nickname);
    }

    /**
     * 查询社区昵称和密码是否在同一条记录中，用于登陆
     */
    @Override
    public String login_nickname(String nickname, String password) {
        return fBlogDao.login_nickname(nickname, password);
    }
}