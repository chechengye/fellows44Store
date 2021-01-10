package com.weichuang.service.impl;

import com.weichuang.dao.ProductDao;
import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;
import com.weichuang.vo.Page;

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

    @Override
    public Product getProductByPid(String pid) {
        return productDao.getProductByPid(pid);
    }

    @Override
    public Page getPageByCurrentPageAndMaxCount(String currentPage, int maxCount) {
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxCount(maxCount);
        page.setTotalCount(productDao.getProductTotalCount());
        //(currentPage - 1) * maxCount
        page.setCurrentIndex((Integer.valueOf(currentPage) - 1) * maxCount);
        page.setProductList(productDao.getProductListByIndexAndMaxCount(page.getCurrentIndex() , page.getMaxCount()));

        page.setTotalPages((int)Math.ceil(page.getTotalCount() * 1.0 / maxCount));
        return page;
    }
}
