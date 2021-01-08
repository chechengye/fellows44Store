package com.weichuang.service;

import com.weichuang.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取商品的列表
     * @return
     */
    List<Product> getProductList();
}
