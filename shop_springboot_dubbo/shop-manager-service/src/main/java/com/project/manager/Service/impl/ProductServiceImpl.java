package com.project.manager.Service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.project.domain.Product;
import com.project.manager.mapper.ProductMapper;
import com.project.manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    /**
     * 查询商品信息
     *
     * @param id 商品ID
     * @return 商品信息
     */
    @Override
    public Product selectProductById(Long id) {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询商品列表
     *
     * @param product 商品信息
     * @return 商品集合
     */
    @Override
    public List<Product> selectProductList(Product product) {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增商品
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    /**
     * 修改商品
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    /**
     * 删除商品
     *
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        return productMapper.deleteProductById(id);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(String[] ids) {
        return productMapper.deleteProductByIds(ids);
    }
}
