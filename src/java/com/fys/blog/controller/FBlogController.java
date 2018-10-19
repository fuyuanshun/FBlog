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
            if (null == fBlogService.userIsExist(username)) {
                User user = new User(username, password, nickname, birthday);
                fBlogService.register(user);
                return "success";
            } else {
                return "用户名已经存在！";
            }
        } else {
            return "请检查是否有选项为空";
        }
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
    public String loginDeal(HttpServletRequest req, @RequestParam("username")String username, @RequestParam("password")String password) {
        if (!isNullOrWhile(username) && !isNullOrWhile(password)) {
            if (null == fBlogService.login(username, password)) {
                return "用户名和密码不匹配!";
            } else {
                req.getSession().setAttribute("username", username);
                return "success";
            }
        }
        return "用户名和密码不能为空！";
    }

    /**
     * 用户退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().removeAttribute("username");
        return "index";
    }
}