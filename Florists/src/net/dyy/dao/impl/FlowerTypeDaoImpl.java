package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.dyy.dao.FlowerTypeDao;
import net.dyy.entity.FlowerType;
import net.dyy.utils.JdbcUtils;

public class FlowerTypeDaoImpl implements FlowerTypeDao{

	@Override
	public List<FlowerType> loadAllFlowerTypes() {
		String sql = "select type_id,type_name from flower_type";

		List<FlowerType> list = new ArrayList<FlowerType>();
		try {
			list = JdbcUtils.getQueryRunner().query(sql, JdbcUtils.getRsListHander(FlowerType.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
