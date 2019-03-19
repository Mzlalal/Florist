package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.FlowerDao;
import net.dyy.dao.ShopCartDao;
import net.dyy.dto.ShopCartDTO;
import net.dyy.utils.JdbcUtils;
import net.dyy.utils.PageBean;

public class ShopCartDaoImpl implements ShopCartDao {
	@Override
	public int isShopCartExisted(Long userId, Long flowerId, int number) {

		String sql = "select car_amount from shopcar where user_id = ? and flower_id = ?;";

		Object[] values = { userId, flowerId };

		Object amount = "";

		// 判断是否存在于购物车
		try {
			amount = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Integer>(), values);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 判断获取是否为空 为空则返回0
		if (amount == null) {
			addTocart(userId, flowerId, number);
			return number;
		}

		// 转换数字
		FlowerDao flowerDao = new FlowerDaoImpl();

		// 获取当前花朵数量
		int nowAmount = flowerDao.getFlowerAmount(flowerId);

		// 如果库存大于当前购物车添加的则执行更新购物车
		if (nowAmount >= number) {
			updateTocart(userId, flowerId, number);
			return number;
		}

		return -1;
	}

	@Override
	public int addTocart(Long userId, Long flowerId, int number) {
		String sql = "insert into shopcar values (?,?,?)";

		Object[] values = { userId, flowerId, number };

		try {
			return JdbcUtils.getQueryRunner().update(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateTocart(Long userId, Long flowerId, int number) {
		String sql = "update shopcar set car_amount = ? where user_id = ? and flower_id = ?;";

		Object[] values = { number, userId, flowerId };

		try {
			return JdbcUtils.getQueryRunner().update(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PageBean<ShopCartDTO> loadShopCartById(PageBean<ShopCartDTO> pageBean) {

		long userId = pageBean.getCondition().getUserId();

		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		sql.append(" 	u.user_id, ");
		sql.append(" 	u.user_name, ");
		sql.append(" 	f.flower_id, ");
		sql.append(" 	f.flower_name, ");
		sql.append(" 	f.flower_amount, ");
		sql.append(" 	f.flower_price, ");
		sql.append(" 	f.flower_desc, ");
		//		sql.append(" 	i.img_adress, ");
		sql.append(" 	f.flower_cover, ");
		sql.append(" 	s.car_amount ");
		sql.append(" from ");
		sql.append(" 	shopcar s, ");
		sql.append(" 	flower f, ");
		sql.append(" 	users u  ");
		//		sql.append(" 	users u , ");
		//		sql.append(" 	img_adress i ");
		sql.append(" where ");
		sql.append(" 	s.user_id = u.user_id  ");
		sql.append(" and s.flower_id = f.flower_id  ");
		//		sql.append(" and f.flower_id = i.flower_id ");
		sql.append(" and s.user_id = ? ");

		List<ShopCartDTO> returnValue = new ArrayList<ShopCartDTO>();
		try {
			returnValue = JdbcUtils.getQueryRunner().query(sql.toString(), JdbcUtils.getRsListHander(ShopCartDTO.class),userId);
			pageBean.setPageData(returnValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pageBean;
	}

	@Override
	public int deleteShopCart(Long userId, Long flowerId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" delete  ");
		sql.append(" from ");
		sql.append(" 	shopcar  ");
		sql.append(" where ");
		sql.append(" 	user_id = ?  ");
		sql.append(" 	and flower_id = ? ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(),userId,flowerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loadShopCartNumByid(long userId, long flowerId) {
		String sql = "select car_amount from shopcar where user_id = ? and flower_id = ?";

		try {
			return JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Integer>(),userId,flowerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
