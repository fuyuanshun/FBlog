package com.fys.blog.service;

import com.fys.blog.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * 用户注册处理
     * @param req
     * @param username 用户名
     * @param password 用户密码
     * @param confirmPassword 确认密码
     * @param nickname 社区昵称
     */
    String registerDeal(HttpServletRequest req, String username, String password, String confirmPassword, String nickname);

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

    /**
     * 用户登录，查询用户名和密码是否存在
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);

    /**
     * 用户登录处理
     * @param req
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String loginDeal(HttpServletRequest req, HttpServletResponse resp, String username, String password);

    /**
     * 更新用户的最后一次登陆时间
     * @param username 需要更新的用户名
     */
    void updateLoginTime(String username);

    /**
     * 根据用户名查询用户的社区名称
     * @param username 用户名
     * @return
     */
    String selectNameByUsername(String username);

    /**
     * 查询一个社区昵称是否已经存在
     * @param nickname 社区昵称
     * @return
     */
    String checkNickname(String nickname);

    /**
     * 查询社区昵称和密码是否在同一条记录中，用于登陆
     * @param nickname 社区昵称
     * @param password 密码
     * @return
     */
    String login_nickname(String nickname, String password);
}
