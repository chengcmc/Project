package com.project.manager.mapper;


import com.project.domain.Order;

import java.util.List;

/**
 * 订单 数据层
 *
 * @author yangbingwen
 * @date 2019-08-01
 */
public interface OrderMapper
{
	/**
     * 查询订单信息
     *
     * @param orderId 订单ID
     * @return 订单信息
     */
	public Order selectOrderById(String orderId);

	/**
     * 查询订单列表
     *
     * @param order 订单信息
     * @return 订单集合
     */
	public List<Order> selectOrderList(Order order);

	/**
     * 新增订单
     *
     * @param order 订单信息
     * @return 结果
     */
	public int insertOrder(Order order);

	/**
     * 修改订单
     *
     * @param order 订单信息
     * @return 结果
     */
	public int updateOrder(Order order);

	/**
     * 删除订单
     *
     * @param orderId 订单ID
     * @return 结果
     */
	public int deleteOrderById(String orderId);

	/**
     * 批量删除订单
     *
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String[] orderIds);

}
