package com.weichuang.admin.controller;

import com.weichuang.admin.pojo.Category;
import com.weichuang.admin.service.CategoryService;
import com.weichuang.admin.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminCategoryList")
public class AdminCategoryListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categoryList = categoryService.getCategoryList();
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("/admin/product/add.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
