package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * 
 * @author 王郁文
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	/**
	 * 查询满足条件的订单信息
	 * 
	 * @param orders     查询条件
	 * @param pageNumber 页数
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {

			PageInfo<Orders> selectOrders = this.ordersService.selectOrders(orders, pageNumber);

			List<Orders> list = selectOrders.getList();

			if (list != null && list.size() > 0) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("ordersList", list);

				// 一页多少行
				PageUtils pageUtils = new PageUtils(selectOrders.getPages() * PageUtils.PAGE_ROW_COUNT);

				// 当前第几页
				pageUtils.setPageNumber(pageNumber);

				map.put("pageUtils", pageUtils);

				rv.setDataMap(map);

				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("没有找到满足条件的订单信息");

		return rv;
	}

	@RequestMapping(value = "/updateOrderStatus")
	public ResultValue updateOrderStatus(Orders orders) {
		ResultValue rv = new ResultValue();

		try {
			Integer status = this.ordersService.updateOrderStatus(orders);
			if (status > 0) {
				rv.setCode(0);
				rv.setMessage("订单状态修改成功！！！");
				return rv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		rv.setCode(1);
		rv.setMessage("修改订单状态失败！！！");
		return rv;
	}

	/**
	 * 查询指定日期范围内的销售额
	 * 
	 * @param orders 查询条件
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			List<Orders> group = this.ordersService.selectGroup(orders);
			if (group != null && group.size() > 0) {

				rv.setCode(0);

				// 创建两个集合
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();

				for (Orders o : group) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("x", x);
				map.put("y", y);

				rv.setDataMap(map);

				return rv;
			}

			return rv;
		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("查询失败！！");
		return rv;
	}
}
