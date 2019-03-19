package net.dyy.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.UserDao;
import net.dyy.entity.Users;
import net.dyy.utils.Condition;
import net.dyy.utils.JdbcUtils;
import net.dyy.utils.PageBean;

public class UserDaoImpl implements UserDao{

	@Override
	public Users selectById(Long id) {
		String sql = "select * from Users where user_id = ? and user_type = 1";

		Users user = null;
		try {
			user = JdbcUtils.getQueryRunner().query(sql,JdbcUtils.getRsHander(Users.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public PageBean<Users> selectUsersByPage(PageBean<Users> pageBean) {
		Condition condition = pageBean.getCondition();

		Long userId = condition.getUserId();

		String userName = condition.getUserName();

		StringBuffer sql = new StringBuffer();

		sql.append(" select  ");
		sql.append("     * ");
		sql.append(" from ");
		sql.append("     (select  ");
		sql.append("         	 user_id, ");
		sql.append("             user_name, ");
		sql.append("             user_pwd, ");
		sql.append("             user_sex, ");
		sql.append("             user_address, ");
		sql.append("             user_birth, ");
		sql.append("             user_phone, ");
		sql.append("             user_credit, ");
		sql.append("             user_type ");
		sql.append("     from ");
		sql.append("         users ");
		sql.append("     where ");
		sql.append("         user_type = 1) u where 1=1");
		// 判断条件
		// 用户id条件
		List<Object> list = new ArrayList<Object>();
		if (userId > 0) {
			sql.append(" and u.user_id=?");
			list.add(userId);
		}

		// 用户名称
		if (userName != null && !"".equals(userName.trim())) {
			sql.append(" and u.user_name like '%" + userName + "%'");
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

		List<Users> returnValue = new ArrayList<Users>();
		try {
			returnValue = JdbcUtils.getQueryRunner().query(sql.toString(),
					JdbcUtils.getRsListHander(Users.class), list.toArray());
			pageBean.setPageData(returnValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pageBean;
	}

	public int getTotalCount(PageBean pb) {
		// 获取条件对象
		Condition condition = pb.getCondition();

		Long userId = condition.getUserId();

		String userName = condition.getUserName();

		StringBuffer sql = new StringBuffer();
		sql.append("select");
		sql.append("		count(*) ");
		sql.append("from ");
		sql.append("		users u ");
		sql.append(" where 1=1");
		sql.append("     and u.user_type = 1 ");
		// 用户id条件
		List<Object> list = new ArrayList<Object>();
		if (userId > 0) {
			sql.append("	or u.user_id=?");
			list.add(userId);
		}
		// 用户名称
		if (userName != null && !"".equals(userName.trim())) {
			sql.append("  or u.user_name like ?");
			list.add(userName);
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
	public int addUser(Users users) {
		List<Object> values = new ArrayList<Object>();

		values.add(users.getUserName());
		values.add(users.getUserPwd());
		values.add(users.getUserSex());
		values.add(users.getUserAddress());
		values.add(users.getUserBirth());
		values.add(users.getUserPhone());

		// sql语句
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into users ( ");
		sql.append(" user_name, ");
		sql.append(" user_pwd, ");
		sql.append(" user_sex, ");
		sql.append(" user_address, ");
		sql.append(" user_birth, ");
		sql.append(" user_phone, ");
		sql.append(" user_credit, ");
		sql.append(" user_type) ");
		sql.append(" values ");
		sql.append(" ( ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" default, ");
		sql.append(" 1); ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), values.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUserById(Long id) {
		// sql语句
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from users where ");
		sql.append(" user_id = ? ");
		sql.append(" and user_type = 1 ");

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
