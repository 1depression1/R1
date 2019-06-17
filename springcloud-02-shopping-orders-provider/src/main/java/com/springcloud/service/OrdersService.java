package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.springcloud.entity.Orders;

/**
 * 订单模块模型层的接口，用于定义订单模型的方法
 * 
 * @author 王郁文
 *
 */
public interface OrdersService {

	/**
	 * 查询满足条件的订单信息(分页功能)
	 * 
	 * @param orders 查询条件
	 * @return 成功返回类型的实例
	 */
	public PageInfo<Orders> selectOrders(Orders orders, Integer pageNumber);

	/**
	 * 修改Orders表中指定Order_id订单的信息
	 * 
	 * @param orders 修改订单的信息
	 * @return 成功返回大于0的整数，否则返回小于等于0的整数
	 */
	public abstract Integer updateOrderStatus(Orders orders);

	/**
	 * 查询指定日期范围内的销售额
	 * 
	 * @param orders 查询条件
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<Orders> selectGroup(Orders orders);
}
