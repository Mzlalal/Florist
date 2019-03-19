package net.dyy.dao;

import java.util.List;

import net.dyy.entity.Orders;
import net.dyy.utils.PageBean;

/**
 * 订单 dao
 * @author Dyy
 *
 */
public interface OrderDao {

	/**
	 * 生成订单
	 * @param userId
	 * @param orderTitle
	 * @param orderDate
	 * @return 0 失败 1成功
	 */
	long createOrder(List<Object> values);

	/**
	 * 查看订单
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean loadOrderByPage(PageBean pageBean);

	/**
	 * 查找最新生成的主键 select last insert key 有延迟 未知
	 * @param values
	 * @return
	 */
	Integer selectId(List<Object> values);

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
	int updateOrderById(String orderId,String phone,String address);

	/**
	 * 获取ID的订单收货地址和电话
	 * @param values
	 * @return
	 */
	Orders selectById(String orderId);
}
