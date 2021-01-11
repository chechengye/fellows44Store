package com.weichuang.admin.controller;

import com.weichuang.admin.pojo.Product;
import com.weichuang.admin.service.CategoryService;
import com.weichuang.admin.service.ProductService;
import com.weichuang.admin.service.impl.CategoryServiceImpl;
import com.weichuang.admin.service.impl.ProductServiceImpl;
import com.weichuang.admin.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/adminSearchProductList")
public class AdminSearchProductListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Condition condition = new Condition();
            ProductService productService = new ProductServiceImpl();
            CategoryService categoryService = new CategoryServiceImpl();
            BeanUtils.populate(condition , req.getParameterMap());
            System.out.println("condition = " + condition);
            List<Product> productList = productService.getProductListByCondition(condition);
            req.setAttribute("productList",productList);
            req.setAttribute("categoryList",categoryService.getCategoryList());
            req.setAttribute("condition",condition);
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req,resp);
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
