package com.weichuang.admin.service.impl;

import com.weichuang.admin.dao.ProductDao;
import com.weichuang.admin.pojo.Product;
import com.weichuang.admin.service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;
    public ProductServiceImpl(){
        productDao = new ProductDao();
    }
    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public int deleteProductByPid(String pid) {
        return productDao.deleteProductByPid(pid);
    }

    @Override
    public int saveProduct(Product product) {
        product.setIsDelete(0);
        product.setPimage("products/1/c_0037.jpg");
        product.setPflag(0);
        product.setPid(UUID.randomUUID().toString().replaceAll("-",""));
        return productDao.saveProduct(product);
    }
}
