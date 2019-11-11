package com.project.manager.service;

import com.project.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询商品信息
     *
     * @param id 商品ID
     * @return 商品信息
     */
    public Product selectProductById(Long id);

    /**
     * 查询商品列表
     *
     * @param product 商品信息
     * @return 商品集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增商品
     *
     * @param product 商品信息
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改商品
     *
     * @param product 商品信息
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 删除商品
     *
     * @param id 商品ID
     * @return 结果
     */
    public int deleteProductById(Long id);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductByIds(String[] ids);
}
