package net.dyy.service;

import net.dyy.dto.ShopCartDTO;
import net.dyy.utils.PageBean;

/**
 * 购物车
 *
 * @author Dyy
 *
 */
public interface ShopCartService {
	/**
	 * 判断是否存在与购物车
	 *
	 * @param userId
	 * @param flowerId
	 * @param number
	 * @return 当前购物车数量 0 失败 -1库存不足
	 */
	int isShopCartExisted(Long userId, Long flowerId, int number);

	/**
	 * 根据用户 id 查找购物车
	 *
	 * @param userId
	 * @param flowerId
	 * @return PageBean
	 */
	PageBean<ShopCartDTO> loadShopCartById(PageBean<ShopCartDTO> pageBean);

	/**
	 * 通过花朵id信息删除购物车
	 *
	 * @param userId
	 * @param FlowerId
	 * @return 0 失败 1 成功
	 */
	int deleteShopCart(Long userId, Long flowerId);

	/**
	 * 根据花朵id 用户id查找购物车库存
	 * @param userId
	 * @param flowerId
	 * @return
	 */
	public int loadShopCartNumByid (long userId , long flowerId);

}
