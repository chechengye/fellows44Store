package com.weichuang.admin.service;

import com.weichuang.admin.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 获取所有的分类列表
     * @return
     */
    List<Category> getCategoryList();
}
