package net.dyy.dao.impl;

import java.sql.SQLException;

import net.dyy.dao.OrderManageDao;
import net.dyy.utils.JdbcUtils;

public class OrderManageDaoImpl implements OrderManageDao{

	@Override
	public int deleteOrderById(long orderId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from order_detail  ");
		sql.append(" where ");
		sql.append("     order_id = ? ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), orderId);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
