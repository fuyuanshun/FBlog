package com.fys.blog.controller;

import com.fys.blog.pojo.Post_;
import com.fys.blog.service.FBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.fys.blog.util.CheckInfo.isNullOrWhile;

@Controller
public class FBlogController {
    @Autowired()
    private FBlogService fBlogService;

    @RequestMapping("/")
    public String index(HttpServletRequest req, HttpServletResponse resp) {
        List<Post_> posts = fBlogService.selectPost();
        req.setAttribute("posts", posts);
        return "index";
    }

    /**
     * 用户注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 用户登陆页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户注册处理
     */
    @RequestMapping("/registerDeal")
    @ResponseBody
    public String registerDeal(HttpServletRequest req, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("confirmPassword") String confirmPassword, @RequestParam("nickname")String nickname) {
        return fBlogService.registerDeal(req, username, password, confirmPassword, nickname);
    }

    /**
     * Ajax异步检查用户名是否已经存在于数据库
     */
    @RequestMapping("/checkUserIsExist")
    @ResponseBody
    public String checkUserIsExist(HttpServletRequest req, @RequestParam("username")String username) {
        return fBlogService.checkUserIsExist(username);
    }

    /**
     * 用户登陆处理
     */
    @RequestMapping("/loginDeal")
    @ResponseBody
    public String loginDeal(HttpServletRequest req, HttpServletResponse resp, @RequestParam("username")String username, @RequestParam("password")String password) {
        return fBlogService.loginDeal(req, resp, username, password);
    }

    /**
     * 用户退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().removeAttribute("nickName");
        req.getSession().removeAttribute("level");
        return "redirect:/";
    }

    /**
     * 异步查询社区昵称是否已经存在
     * @param nickname 社区昵称
     * @return
     */
    @RequestMapping("/checkNickname")
    @ResponseBody
    public String checkNickname(@RequestParam("nickname")String nickname) {
        if (!isNullOrWhile(nickname)) {
            String nickName = fBlogService.checkNickname(nickname);
            if (nickName == null) {
                return "该社区昵称可以使用";
            }
        }
        return "该社区昵称已经存在";
    }

    @RequestMapping("/post")
    public String post(HttpServletRequest req, @RequestParam("id")String id) {
        Post_ post = fBlogService.post_detail(id);
        List<Post_> posts =  fBlogService.selectPost();
        if (null != post) {
            req.setAttribute("post", post);
        }
        if (null != posts) {
            req.setAttribute("posts", posts);
        }
        return "post_detail";
    }

    /**
     * 删除指定id以及所有子节点的贴子.
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteAll", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAll(@RequestParam("id")String id) {
        fBlogService.deleteAll(id);
        return "删除成功!";
    }

    /**
     * 添加贴子
     * @return
     */
    @RequestMapping(value="/addPost", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(@RequestParam("id")String id, @RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("nickname")String nickname) {
        return fBlogService.addPost(id, title, content, nickname);
    }

}