package com.fys.blog.controller;

import com.fys.blog.service.FBlogService;
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
     * 用户注册处理
     */
    @RequestMapping("/registerDeal")
    @ResponseBody
    public String registerDeal(HttpServletRequest req, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("nickname")String nickname) {
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String birthday = null;
        if (!isNullOrWhile(year) && !isNullOrWhile(month) && !isNullOrWhile(day)) {
            birthday = year + "-" + month + "-" + day;
        }
        if (!isNullOrWhile(username) && !isNullOrWhile(password) && !isNullOrWhile(nickname) && !isNullOrWhile(birthday)) {
            System.out.println(username);
            System.out.println(password);
            System.out.println(nickname);
        } else {
            System.out.println("有为空的属性哦~~~~~~~~");
        }
        return "/";
    }
}