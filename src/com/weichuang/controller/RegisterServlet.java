package com.weichuang.controller;

import com.weichuang.pojo.User;
import com.weichuang.service.UserService;
import com.weichuang.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            UserService userService = new UserServiceImpl();
            //处理中文乱码问题
            req.setCharacterEncoding("utf-8");
            //进行参数接收
            Map<String, String[]> parameterMap = req.getParameterMap();
            User user = new User();
            BeanUtils.populate(user , parameterMap);
            int rows = userService.registerUser(user , req.getParameterValues("hobby"));
            if(rows > 0){
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }else{
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
