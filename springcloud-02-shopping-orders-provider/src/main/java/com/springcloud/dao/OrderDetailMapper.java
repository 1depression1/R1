package com.springcloud.dao;

import com.springcloud.entity.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order_detail
	 *
	 * @mbg.generated Fri May 31 16:47:52 CST 2019
	 */
	int deleteByPrimaryKey(Integer orderDetailId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order_detail
	 *
	 * @mbg.generated Fri May 31 16:47:52 CST 2019
	 */
	int insert(OrderDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order_detail
	 *
	 * @mbg.generated Fri May 31 16:47:52 CST 2019
	 */
	OrderDetail selectByPrimaryKey(Integer orderDetailId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order_detail
	 *
	 * @mbg.generated Fri May 31 16:47:52 CST 2019
	 */
	List<OrderDetail> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table order_detail
	 *
	 * @mbg.generated Fri May 31 16:47:52 CST 2019
	 */
	int updateByPrimaryKey(OrderDetail record);

	/**
	 * 查询指定订单编号的订单明细信息
	 * 
	 * @param orderId 订单编号
	 * @return 成功返回java.util。List类型的实例，否则返回null
	 */
	public abstract List<OrderDetail> selectByOrderId(Integer orderId);
}