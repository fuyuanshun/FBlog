package com.fys.blog.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        /**
         *  放行用户的注册，登陆和处理页面
         */
        if(uri.contains("/FBlog/login")){
            return true;
        } else if (uri.contains("/FBlog/loginDeal")) {
            return true;
        } else if (uri.contains("/FBlog/register")) {
            return true;
        } else if (uri.contains("/FBlog/registerDeal")) {
            return true;
        } else if (uri.equals("/FBlog/")) {
            return true;
        }
        /**
         * 查看session中是否有数据
         */
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("nickName");
        if(null != username) {
            return true;
        }

        /**
         * 如果执行到这里说明需要身份验证
         */
        request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

}