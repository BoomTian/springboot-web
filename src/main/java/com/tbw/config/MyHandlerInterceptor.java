package com.tbw.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        //登录了在session中存名字，这里取不到就是没登录，跳到登录界面
        if (loginUser == null){
            request.setAttribute("msg","沒有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }
}
