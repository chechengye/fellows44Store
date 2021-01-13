package com.weichuang.web.controller;

import com.weichuang.web.pojo.Cart;
import com.weichuang.web.service.CartService;
import com.weichuang.web.service.impl.CartServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/cartSave")
public class CartSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            Cart cart = new Cart();
            BeanUtils.populate(cart , req.getParameterMap());
            //查询数据是否已存在于购物车中
            CartService cartService = new CartServiceImpl();
            Cart oldCart = cartService.findCartByUidAndPid(cart.getPid() , cart.getUid());
            int rows = 0;
            if(null != oldCart){
                oldCart.setCount(cart.getCount() + oldCart.getCount());
                rows = cartService.updateCart(oldCart);
            }else{
                rows = cartService.insertCart(cart);
            }

            if(rows > 0){
                resp.getWriter().write("添加购物车成功!");
            }else{
                resp.getWriter().write("添加失败!");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
