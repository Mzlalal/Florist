package net.dyy.service;

/**
 * 订单管理
 * @author Mzlalal
 *
 */
public interface OrderManageService {
	/**
	 * 通过id删除订单
	 * @param orderId
	 * @return
	 */
	boolean deleteOrderById(long orderId);
}
