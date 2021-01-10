package com.weichuang.admin.controller;


import com.weichuang.admin.service.ProductService;
import com.weichuang.admin.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminDeleteProduct")
public class AdminDeleteProductServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");
        int rows = productService.deleteProductByPid(pid);
        if(rows > 0){
            resp.sendRedirect(req.getContextPath() + "/adminProductList");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
