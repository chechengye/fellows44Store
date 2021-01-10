package com.weichuang.admin.service;

import com.weichuang.admin.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    /**
     * 根据pid删除商品
     * @param pid
     * @return
     */
    int deleteProductByPid(String pid);

    /**
     * 添加商品
     * @param product
     * @return
     */
    int saveProduct(Product product);
}
