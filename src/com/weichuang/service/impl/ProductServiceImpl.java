package com.weichuang.service.impl;

import com.weichuang.dao.ProductDao;
import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao ;
    public ProductServiceImpl(){
        this.productDao = new ProductDao();
    }
    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }
}
