package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.OrderDao;
import net.dyy.dto.OrderDetailFlowerDTO;
import net.dyy.entity.Orders;
import net.dyy.utils.Condition;
import net.dyy.utils.JdbcUtils;
import net.dyy.utils.PageBean;

public class OrderDaoImpl implements OrderDao {

	@Override
	public long createOrder(List<Object> values) {
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into orders ( user_id, order_title, order_date, order_type , final_address, final_phone) ");
		sql.append(" values ");
		sql.append(" 	( ?, ?, ?, ?, ?, ? ); ");

		try {
			JdbcUtils.getQueryRunner().update(sql.toString(), values.toArray());

			return selectId(values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean loadOrderByPage(PageBean pageBean) {

		// 获取条件
		Condition condition = pageBean.getCondition();

		StringBuffer sql = new StringBuffer();

		List<Object> list = new ArrayList<Object>();
		sql.append(" select ");
		sql.append(" 	u.user_id, ");
		sql.append(" 	u.user_name, ");
		sql.append(" 	o.order_id, ");
		sql.append(" 	o.order_title, ");
		sql.append(" 	o.final_address, ");
		sql.append(" 	o.final_phone, ");
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


		long orderId = condition.getOrderId();

		if (orderId > 0) {
			sql.append(" 	and o.order_id = ? ");
			list.add(orderId);
		}

		String orderName = condition.getOrderName();
		if (orderId > 0) {
			sql.append(" 	and o.order_name = ? ");
			list.add(orderName);
		}

		try {
			List<OrderDetailFlowerDTO> result = JdbcUtils.getQueryRunner().query(sql.toString(),
					JdbcUtils.getRsListHander(OrderDetailFlowerDTO.class),list.toArray());
			pageBean.setPageData(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pageBean;
	}

	@Override
	public Integer selectId(List<Object> values) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		sql.append(" 	order_id  ");
		sql.append(" from ");
		sql.append(" 	orders  ");
		sql.append(" where ");
		sql.append(" 	user_id = ? ");
		sql.append(" 	and order_title = ? ");
		sql.append(" 	and order_date = ? ");
		sql.append(" 	and order_type = ? ");
		sql.append(" 	and final_address = ? ");
		sql.append(" 	and final_phone = ? ");


		try {
			return JdbcUtils.getQueryRunner().query(sql.toString(), new ScalarHandler<Integer>(), values.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int deleteOrderById(String orderId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from orders  ");
		sql.append(" where ");
		sql.append("     order_id = ? ");


		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), orderId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int updateOrderById(String orderId,String phone,String address) {
		StringBuffer sql = new StringBuffer();

		sql.append(" update orders o  ");
		sql.append(" set  ");
		sql.append("     o.final_phone = ?, ");
		sql.append(" 	 o.final_address = ? ");
		sql.append(" where ");
		sql.append("     o.order_id = ? ");
		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), phone, address, orderId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Orders selectById(String orderId) {
		StringBuffer sql = new StringBuffer();

		// 定义sql
		sql.append(" select order_id, final_phone, final_address from orders where order_id = ? ");

		try {
			return JdbcUtils.getQueryRunner().query(sql.toString(),JdbcUtils.getRsHander(Orders.class), orderId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
