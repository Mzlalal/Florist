package net.dyy.service.impl;

import java.util.List;

import net.dyy.dao.OrderDetailDao;
import net.dyy.dao.impl.OrderDetailDaoImpl;
import net.dyy.dto.OrderDetailFlowerDTO;
import net.dyy.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

	OrderDetailDao dao = new OrderDetailDaoImpl();

	@Override
	public int createOrederDetail(long orderId, long flowerId, int flowerAmount) {
		try {
			return dao.createOrederDetail(orderId, flowerId, flowerAmount);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<OrderDetailFlowerDTO> loadOrderDetailById(long orderId) {
		try {
			return dao.loadOrderDetailById(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
