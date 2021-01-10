package com.weichuang.web.controller;

import com.weichuang.web.pojo.User;
import com.weichuang.web.service.UserService;
import com.weichuang.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();
        //解决前端传递中文乱码问题
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username , password);
        if(null != user){
            System.out.println("登录成功！");
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("JSESSIONID" , session.getId());
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            System.out.println("登录失败！");
            req.setAttribute("loginInfo" ,"用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
