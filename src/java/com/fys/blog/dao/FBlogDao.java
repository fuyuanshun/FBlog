package com.fys.blog.dao;

import com.fys.blog.pojo.Post_;
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
     * 查询所有的贴子
     * @return
     */
    List<Post_> selectPost();

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
    String login_nickname(@Param("nickname")String nickname, @Param("password") String password);


    /**
     * 根据帖子id查询贴子的详细内容
     * @param id id
     * @return
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
}
