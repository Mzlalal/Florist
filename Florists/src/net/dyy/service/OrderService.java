package net.dyy.service;

import java.util.List;

import net.dyy.entity.Orders;
import net.dyy.utils.PageBean;

/**
 * 订单service
 * @author Dyy
 *
 */
public interface OrderService {
	/**
	 * 生成订单
	 * @param userId
	 * @param orderTitle
	 * @param orderDate
	 * @return 0 失败 1成功
	 */
	long createOrder(List values);

	/**
	 * 查看订单
	 * @param userId
	 * @return
	 */
	PageBean loadOrderByPage(PageBean pageBean);

	/**
	 * 通过ID删除订单
	 * @param orderId
	 * @return
	 */
	int deleteOrderById(String orderId);

	/**
	 * 更新订单信息 修改联系电话 收货地址
	 * @param orderId
	 * @return int
	 */
	boolean updateOrderById(String orderId,String phone,String address);

	/**
	 * 获取ID的订单收货地址和电话
	 * @param values
	 * @return
	 */
	Orders selectById(String orderId);
}
