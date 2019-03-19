package net.dyy.service.impl;

import net.dyy.dao.ShopCartDao;
import net.dyy.dao.impl.ShopCartDaoImpl;
import net.dyy.dto.ShopCartDTO;
import net.dyy.service.ShopCartService;
import net.dyy.utils.PageBean;

public class ShopCartServiceImpl implements ShopCartService{

	ShopCartDao dao = new ShopCartDaoImpl();

	@Override
	public int isShopCartExisted(Long userId, Long flowerId, int number) {
		try {
			return dao.isShopCartExisted(userId, flowerId, number);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean<ShopCartDTO> loadShopCartById(PageBean<ShopCartDTO> pageBean) {
		try {
			return dao.loadShopCartById(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteShopCart(Long userId, Long flowerId) {
		try {
			return dao.deleteShopCart(userId,flowerId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int loadShopCartNumByid(long userId, long flowerId) {
		try {
			return dao.loadShopCartNumByid(userId,flowerId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
