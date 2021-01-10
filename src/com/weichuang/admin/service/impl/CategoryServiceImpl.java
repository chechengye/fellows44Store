package com.weichuang.admin.service.impl;

import com.weichuang.admin.dao.CategoryDao;
import com.weichuang.admin.pojo.Category;
import com.weichuang.admin.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao;

    public CategoryServiceImpl(){
        categoryDao = new CategoryDao();
    }
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
