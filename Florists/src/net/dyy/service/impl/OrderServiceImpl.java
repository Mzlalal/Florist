package net.dyy.service.impl;

import java.util.List;

import net.dyy.dao.OrderDao;
import net.dyy.dao.OrderManageDao;
import net.dyy.dao.impl.OrderDaoImpl;
import net.dyy.dao.impl.OrderManageDaoImpl;
import net.dyy.entity.Orders;
import net.dyy.service.OrderService;
import net.dyy.utils.PageBean;

public class OrderServiceImpl implements OrderService {

	OrderDao dao = new OrderDaoImpl();
	OrderManageDao manageDao = new OrderManageDaoImpl();

	@Override
	public long createOrder(List values) {
		try {
			return dao.createOrder(values);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean loadOrderByPage(PageBean pageBean) {
		try {
			return dao.loadOrderByPage(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteOrderById(String orderId) {
		try {
			int flag2 = manageDao.deleteOrderById(Integer.valueOf(orderId));
			int flag1 = dao.deleteOrderById(orderId);
			if (flag1 > 0 && flag2 > 0) {
				return flag1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean updateOrderById(String orderId,String phone,String address) {
		try {
			return dao.updateOrderById(orderId, phone, address) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Orders selectById(String orderId) {
		try {
			return dao.selectById(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
