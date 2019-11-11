package com.project.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.project.domain.Product;
import com.project.manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/restful/page")
@Controller
public class ProductController {
    @Reference
    private ProductService productService;
    @PostMapping("product")
    @ResponseBody
    public ResponseEntity<Void> insertProduct(Product product){
        try{
            System.out.println("待添加商品数据："+product.getTitle());
            this.productService.insertProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
