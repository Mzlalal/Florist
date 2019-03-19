package net.dyy.dao;

import java.util.List;

import net.dyy.dto.OrderDetailFlowerDTO;

/**
 *
 * 订单详情dao
 * @author Mzlalal
 *
 */
public interface OrderDetailDao {
	/**
	 * 购买商品
	 * @param userId
	 * @param flowerId
	 * @param flowerAmount
	 */
	int createOrederDetail(long orderId,long flowerId,int flowerAmount);

	/**
	 * 通过id 查询订单详情
	 * @param orderId
	 * @return List 订单详情商品信息
	 */
	List<OrderDetailFlowerDTO> loadOrderDetailById(long orderId);
}
