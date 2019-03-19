package net.dyy.dao;

/**
 * 订单管理
 * @author Mzlalal
 *
 */
public interface OrderManageDao {

	/**
	 * 通过id更新订单
	 * @param orderId
	 * @return
	 */
	//	int updateOrderById(long orderId);

	/**
	 * 通过id删除订单
	 * @param orderId
	 * @return
	 */
	int deleteOrderById(long orderId);

}
