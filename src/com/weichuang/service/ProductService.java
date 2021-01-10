package com.weichuang.service;

import com.weichuang.pojo.Product;
import com.weichuang.vo.Page;

import java.util.List;

public interface ProductService {
    /**
     * 获取商品的列表
     * @return
     */
    List<Product> getProductList();

    /**
     * 根据id获取商品信息
     * @param pid
     * @return
     */
    Product getProductByPid(String pid);

    /**
     * 封装获取page数据
     * @param currentPage
     * @param maxCount
     * @return
     */
    Page getPageByCurrentPageAndMaxCount(String currentPage, int maxCount);
}
