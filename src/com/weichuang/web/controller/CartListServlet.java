package com.weichuang.web.controller;

import com.weichuang.web.pojo.Cart;
import com.weichuang.web.pojo.CartAndProduct;
import com.weichuang.web.service.CartService;
import com.weichuang.web.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CartService cartService = new CartServiceImpl();
        List<CartAndProduct> cartAndProductList = cartService.getCartListByUid(req.getParameter("uid"));
        req.setAttribute("cartAndProductList",cartAndProductList);
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
