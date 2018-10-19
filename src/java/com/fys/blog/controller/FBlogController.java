package com.fys.blog.controller;

import com.fys.blog.pojo.User;
import com.fys.blog.service.FBlogService;
import com.fys.blog.util.CheckInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.fys.blog.util.CheckInfo.isNullOrWhile;

@Controller
public class FBlogController {
    @Autowired()
    private FBlogService fBlogService;

    @RequestMapping("/")
    public String index() {
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
        return "index";
    }

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
}