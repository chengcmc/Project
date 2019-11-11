package com.project.manager.service;

import com.project.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> selectCategoryList(Category category);
}
