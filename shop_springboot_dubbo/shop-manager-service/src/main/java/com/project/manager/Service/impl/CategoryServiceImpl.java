package com.project.manager.Service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.project.domain.Category;
import com.project.manager.mapper.CategoryMapper;
import com.project.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }
}
