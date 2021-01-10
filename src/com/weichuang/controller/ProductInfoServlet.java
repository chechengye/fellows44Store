package com.weichuang.controller;

import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;
import com.weichuang.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2、优先处理乱码
        req.setCharacterEncoding("utf-8");
        //1、接收前端传递的参数
        String pid = req.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductByPid(pid);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product_info.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
