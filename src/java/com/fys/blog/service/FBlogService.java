package com.fys.blog.service;

import com.fys.blog.pojo.Post_;
import com.fys.blog.pojo.User;

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
     * 查询所有的贴子
     */
    List<Post_> selectPost();

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

    /**
     * 根据贴子id查询详细贴子
     */
    Post_ post_detail(String id);

    /**
     * 根据社区昵称查询权限等级
     * @param nickname 社区昵称
     * @return
     */
    String getLevelByNickname(String nickname);


    /**
     * 根据用户账号查询权限等级
     * @param username 用户账号
     * @return
     */
    String getLevelByUsername(String username);

    /**
     *  根据id删除贴子
     * @param id
     */
    void deleteById(String id);


    /**
     * 根据id查询所有的子节点
     * @param id
     * @return
     */
    List<Post_> selectById(String id);


    /**
     * 删除指定id的所有子节点
     * @param id
     */
    void deleteAll(String id);

    /**
     * 回复贴子
     */
    String addPost(String id, String title, String content, String nickname);

    /**
     * 发新帖子
     * @param title
     * @param content
     * @param nickname
     * @return
     */
    String newPost(String title, String content, String nickname);
}
