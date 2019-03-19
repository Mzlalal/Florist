package net.dyy.service.impl;

import net.dyy.dao.OrderManageDao;
import net.dyy.dao.impl.OrderManageDaoImpl;
import net.dyy.service.OrderManageService;

public class OrderManageServiceImpl implements OrderManageService{

	OrderManageDao orderManageDao = new OrderManageDaoImpl();

	@Override
	public boolean deleteOrderById(long orderId) {
		return orderManageDao.deleteOrderById(orderId) > 0 ? true : false;
	}

}
