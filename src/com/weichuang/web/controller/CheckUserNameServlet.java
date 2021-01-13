package com.weichuang.web.controller;

import com.weichuang.web.service.UserService;
import com.weichuang.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUserName")
public class CheckUserNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("userName");
        UserService userService = new UserServiceImpl();
        int count = userService.checkUserNameIsExist(userName);
        if(count > 0){
            resp.getWriter().write("此用户名已存在!");
        }else{
            resp.getWriter().write("用户名可用!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
