package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import net.dyy.dao.OrderDetailDao;
import net.dyy.dto.OrderDetailFlowerDTO;
import net.dyy.utils.JdbcUtils;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public int createOrederDetail(long orderId, long flowerId, int flowerAmount) {
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into order_detail ( order_id, flower_id, order_amount ) ");
		sql.append(" values ");
		sql.append(" 	( ?, ?, ? ); ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), orderId, flowerId, flowerAmount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<OrderDetailFlowerDTO> loadOrderDetailById(long orderId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		sql.append(" 	u.user_id, ");
		sql.append(" 	u.user_name, ");
		sql.append(" 	o.order_id, ");
		sql.append(" 	o.order_date, ");
		sql.append(" 	o.order_title, ");
		sql.append(" 	od.order_amount, ");
		sql.append(" 	f.flower_id, ");
		sql.append(" 	f.flower_name, ");
		sql.append(" 	f.flower_price, ");
		sql.append(" 	f.flower_cover, ");
		sql.append(" 	f.flower_desc, ");
		sql.append(" 	f.user_id sellerId, ");
		sql.append(" 	( select user_name from users where user_id = sellerid ) seller_name  ");
		sql.append(" from ");
		sql.append(" 	order_detail od, ");
		sql.append(" 	orders o, ");
		sql.append(" 	users u, ");
		sql.append(" 	flower f  ");
		sql.append(" where ");
		sql.append(" 	od.order_id = o.order_id  ");
		sql.append(" 	and o.user_id = u.user_id  ");
		sql.append(" 	and od.flower_id = f.flower_id  ");
		sql.append(" 	and od.order_id = ? ");

		try {
			return JdbcUtils.getQueryRunner().query(sql.toString(),
					JdbcUtils.getRsListHander(OrderDetailFlowerDTO.class), orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
