package com.project.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.project.domain.Category;
import com.project.manager.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/restful/page")
public class CategoryController {
    //注入商品分类，使用@reference引用远程服务
    @Reference
    private CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<List<Category>> selectCategoryList(Category category){
        try{
            List<Category> categoryList=categoryService.selectCategoryList(category);
            return ResponseEntity.status(HttpStatus.OK).body(categoryList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
