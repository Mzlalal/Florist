package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.TypeDao;
import net.dyy.entity.Type;
import net.dyy.utils.Condition;
import net.dyy.utils.JdbcUtils;
import net.dyy.utils.PageBean;

public class TypeDaoImpl implements TypeDao{

	@Override
	public Type selectById(Long id) {
		// 定义sql
		String sql = "select * from FLOWER_TYPE where type_id = ?";

		Type type = null;

		// 获取结果
		try {
			type = JdbcUtils.getQueryRunner().query(sql,JdbcUtils.getRsHander(Type.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public PageBean<Type> selectTypesByPage(PageBean<Type> pageBean) {
		// 条件
		Condition condition = pageBean.getCondition();

		long typeId = condition.getTypeId();

		String typeName = condition.getTypeName();

		// 定义sql
		StringBuffer sql = new StringBuffer();

		sql.append(" select * from flower_type where 1=1 ");
		// 判断条件
		// 用户id条件
		List<Object> list = new ArrayList<Object>();
		if (typeId > 0) {
			sql.append(" or type_id=?");
			list.add(typeId);
		}

		// 用户名称
		if (typeName != null && !"".equals(typeName.trim())) {
			sql.append(" or type_name like '%" + typeName + "%'");
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

		List<Type> returnValue = new ArrayList<Type>();
		try {
			returnValue = JdbcUtils.getQueryRunner().query(sql.toString(),
					JdbcUtils.getRsListHander(Type.class), list.toArray());
			pageBean.setPageData(returnValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pageBean;
	}

	public int getTotalCount(PageBean pb) {
		// 获取条件对象
		Condition condition = pb.getCondition();

		Long typeId = condition.getTypeId();

		String typeName = condition.getTypeName();

		StringBuffer sql = new StringBuffer();
		sql.append("select");
		sql.append("		count(*) ");
		sql.append("from ");
		sql.append("		flower_type  ");
		sql.append(" where 1=1");

		// 用户id条件
		List<Object> list = new ArrayList<Object>();
		if (typeId > 0) {
			sql.append("	or type_id=?");
			list.add(typeId);
		}
		// 用户名称
		if (typeName != null && !"".equals(typeName.trim())) {
			sql.append(" or type_name like '%" + typeName + "%'");
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
	public int addType(Type types) {
		List<Object> values = new ArrayList<Object>();

		values.add(types.getTypeName());

		// sql语句
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into flower_type ( ");
		sql.append(" type_name) ");
		sql.append(" values ");
		sql.append(" (?); ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), values.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTypeById(Long id) {
		// sql语句
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from flower_type where ");
		sql.append(" type_id = ? ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int typeExisted(String typeName) {
		// 定义sql
		String sql = "select count(*) from FLOWER_TYPE where type_name = ?";

		try {
			return JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Long>(), typeName).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTypeById(Long id, String typeName) {
		// 定义sql
		String sql = "update FLOWER_TYPE set type_name = ? where type_id = ?";

		try {
			return JdbcUtils.getQueryRunner().update(sql, typeName,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
