package com.weichuang.web.controller;

import com.alibaba.fastjson.JSON;
import com.weichuang.web.pojo.Product;
import com.weichuang.web.service.ProductService;
import com.weichuang.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchProductByWord")
public class SearchProductByWordServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String word = req.getParameter("word");
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getSearchProductByWord(word);
        System.out.println("size = " + productList.size());
        String toJSONString = JSON.toJSONString(productList);
        System.out.println("toJSONString =" + toJSONString);
        resp.getWriter().write(toJSONString);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
