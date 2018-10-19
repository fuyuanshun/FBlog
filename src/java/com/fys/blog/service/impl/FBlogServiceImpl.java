package com.fys.blog.service.impl;

import com.fys.blog.dao.FBlogDao;
import com.fys.blog.pojo.User;
import com.fys.blog.service.FBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.fys.blog.util.CheckInfo.isNullOrWhile;

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
     * 用户注册处理
     * @param req
     * @param username 用户名
     * @param password 用户密码
     * @param confirmPassword 确认密码
     * @param nickname 社区昵称
     */
    @Override
    public String registerDeal(HttpServletRequest req, String username, String password, String confirmPassword, String nickname) {
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String birthday = null;
        //保证用户提交的信息不为空，初始化生日变量
        if (!isNullOrWhile(year) && !isNullOrWhile(month) && !isNullOrWhile(day)) {
            birthday = year + "-" + month + "-" + day;
        }
        //保证用户提交的其他信息不为空，存储到数据库
        if (!isNullOrWhile(username) && !isNullOrWhile(password) && !isNullOrWhile(confirmPassword) && !isNullOrWhile(nickname) && !isNullOrWhile(birthday) && confirmPassword.equals(password)) {
            if (null == userIsExist(username)) {
                User user = new User(username, password, nickname, birthday);
                register(user);
                return "success";
            } else {
                return "用户名已经存在！";
            }
        } else {
            return "请检查是否有选项为空";
        }
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

    @Override
    public String loginDeal(HttpServletRequest req, HttpServletResponse resp, String username, String password) {
        if (!isNullOrWhile(username) && !isNullOrWhile(password)) {
            //设置cookie， 记住用户名
            if (null != req.getParameter("remUsername")) {
                Cookie cookie = new Cookie("cookie-user", username);
                cookie.setMaxAge(60*60*24*30); //单位为秒 保存30天
                resp.addCookie(cookie);
            }

            //设置cookie, 记住密码
            if (null != req.getParameter("remPassword")) {
                Cookie cookie = new Cookie("cookie-password", password);
                cookie.setMaxAge(60*60*24*30); //单位为秒 保存30天
                resp.addCookie(cookie);
            }


            if (null != login(username, password) || null != login_nickname(username, password)) {
                //查询是否存在
                if (null == selectNameByUsername(username)) {
                    req.getSession().setAttribute("nickName", username);
                    updateLoginTime(username);
                    return "success";
                } else {
                    String nickName = selectNameByUsername(username);
                    req.getSession().setAttribute("nickName", nickName);
                    updateLoginTime(username);
                    return "success";
                }
            } else {
                return "用户名和密码不匹配!";
            }
        }
        return "用户名和密码不能为空！";
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