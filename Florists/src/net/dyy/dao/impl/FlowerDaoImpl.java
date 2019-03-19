package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.FlowerDao;
import net.dyy.dto.FlowerUserDTO;
import net.dyy.entity.Flower;
import net.dyy.utils.Condition;
import net.dyy.utils.JdbcUtils;
import net.dyy.utils.PageBean;

public class FlowerDaoImpl implements FlowerDao {

	@Override
	public PageBean<FlowerUserDTO> loadFlowerByPage(PageBean<FlowerUserDTO> pageBean) {
		Condition condition = pageBean.getCondition();

		Long flowerTypeId = condition.getFlowerTypeId();

		String flowerName = condition.getFlowerName();

		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		sql.append(" 	f.flower_id, ");
		sql.append(" 	f.user_id, ");
		sql.append(" 	f.flower_price, ");
		sql.append(" 	f.flower_name, ");
		sql.append(" 	f.flower_cover, ");
		sql.append(" 	f.flower_desc, ");
		sql.append(" 	f.flower_amount, ");
		sql.append(" 	ft.type_name, ");
		sql.append(" 	ft.type_id, ");
		sql.append(" 	u.user_id, ");
		sql.append(" 	u.user_name ");
		sql.append(" from ");
		sql.append(" 	flower_type ft, ");
		sql.append(" 	flower f , ");
		sql.append(" 	users u ");
		sql.append(" where 1=1 ");
		sql.append(" 	and f.type_id = ft.type_id ");
		sql.append(" 	and f.user_id = u.user_id ");

		List<Object> list = new ArrayList<Object>();

		// 判断条件
		if (flowerTypeId > 0) {
			sql.append("and ft.type_id = ?");
			list.add(flowerTypeId);
		}

		if (flowerName != null && !"".equals(flowerName.trim())) {
			sql.append("and f.flower_name = ?");
			list.add(flowerName);
		}

		sql.append(" limit ? , ?");

		// 先查询总记录数
		int totalCount = getTotalCount(pageBean);

		// 设置页码
		pageBean.repeatPageBean(pageBean, totalCount);

		// 起始行
		int index = (pageBean.getCurrentPage() - 1) * pageBean.getPageCount();
		// 返回记录行
		int count = pageBean.getPageCount();

		list.add(index);
		list.add(count);

		List<FlowerUserDTO> returnValue = new ArrayList<FlowerUserDTO>();
		try {
			returnValue = JdbcUtils.getQueryRunner().query(sql.toString(),
					JdbcUtils.getRsListHander(FlowerUserDTO.class), list.toArray());
			pageBean.setPageData(returnValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pageBean;
	}

	@Override
	public int getTotalCount(PageBean pb) {
		// 获取条件对象
		Condition condition = pb.getCondition();

		Long flowerTypeId = condition.getFlowerTypeId();

		String flowerName = condition.getFlowerName();

		StringBuffer sql = new StringBuffer();
		sql.append("select");
		sql.append("		count(*) ");
		sql.append("from ");
		sql.append("		flower_type ft, ");
		sql.append("		flower f  ");
		sql.append(" where 1=1");
		sql.append(" 	and f.type_id = ft.type_id ");

		// 类别id条件
		List<Object> list = new ArrayList<Object>();
		if (flowerTypeId > 0) {
			sql.append("	and f.type_id=?");
			list.add(flowerTypeId);
		}
		// 菜品名称
		if (flowerName != null && !"".equals(flowerName.trim())) {
			sql.append("  and ft.type_name like ?");
			list.add(flowerName);
		}

		Long count = null;
		try {
			count = JdbcUtils.getQueryRunner().query(sql.toString(), new ScalarHandler<Long>(), list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	@Override
	public Flower loadFlowerById(Long id) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ");
		sql.append(" 	f.flower_id, ");
		sql.append(" 	f.user_id, ");
		sql.append(" 	f.flower_price, ");
		sql.append(" 	f.flower_name, ");
		//		sql.append(" 	f.flower_img, ");
		sql.append(" 	f.flower_desc, ");
		sql.append(" 	f.flower_amount, ");
		sql.append(" 	ft.type_name, ");
		sql.append(" 	ft.type_id, ");
		sql.append(" 	u.user_id, ");
		sql.append(" 	u.user_name ");
		sql.append(" from ");
		sql.append(" 	flower_type ft, ");
		sql.append(" 	flower f , ");
		sql.append(" 	users u ");
		sql.append(" where 1=1 ");
		sql.append(" 	and f.type_id = ft.type_id ");
		sql.append(" 	and f.user_id = u.user_id ");
		sql.append(" 	and f.flower_id = ? ");

		Flower flower = null;
		try {
			flower = JdbcUtils.getQueryRunner().query(sql.toString(), JdbcUtils.getRsHander(Flower.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flower;
	}

	@Override
	public int getFlowerAmount(Long id) {
		String sql = "select flower_amount from flower where flower_id = ?";
		Integer amount = 0;
		try {
			amount = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Integer>(),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amount.intValue();
	}

	@Override
	public int deleteFlowerById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFlowerAmount(Long id, int decNum) {
		String sql = "update flower set flower_amount = flower_amount - ? where flower_id = ?;";
		try {
			return JdbcUtils.getQueryRunner().update(sql, decNum,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
