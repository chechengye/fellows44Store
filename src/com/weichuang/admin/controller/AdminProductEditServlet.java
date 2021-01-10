package com.weichuang.admin.controller;

import com.weichuang.admin.pojo.Product;
import com.weichuang.admin.service.CategoryService;
import com.weichuang.admin.service.ProductService;
import com.weichuang.admin.service.impl.CategoryServiceImpl;
import com.weichuang.admin.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminProductEdit")
public class AdminProductEditServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        Product product = productService.getProductByPid(pid);
        req.setAttribute("product",product);
        req.setAttribute("categoryList",categoryService.getCategoryList());
        req.getRequestDispatcher("/admin/product/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
